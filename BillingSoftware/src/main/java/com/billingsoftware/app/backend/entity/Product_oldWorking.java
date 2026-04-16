package com.billingsoftware.app.backend.entity;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product_oldWorking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment PK
    private Long id;

   
    private String name;
    private String packing;
    private String loose;
    private String company;
    private Integer stock;
    private String shelf;
    private String cmp;
    private String hsnNo;
    private String gst;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Batch> batches;

    public Product_oldWorking() {}

	public Product_oldWorking(Long id, String name, String packing, String loose, String company, Integer stock, String shelf,
			String cmp, String hsnNo, String gst, List<Batch> batches) {
		super();
		this.id = id;
		this.name = name;
		this.packing = packing;
		this.loose = loose;
		this.company = company;
		this.stock = stock;
		this.shelf = shelf;
		this.cmp = cmp;
		this.hsnNo = hsnNo;
		this.gst = gst;
		this.batches = batches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public String getLoose() {
		return loose;
	}

	public void setLoose(String loose) {
		this.loose = loose;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getHsnNo() {
		return hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		this.hsnNo = hsnNo;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

    
}
