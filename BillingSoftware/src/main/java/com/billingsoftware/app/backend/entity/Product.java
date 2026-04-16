package com.billingsoftware.app.backend.entity;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long appid;

    // BASIC
    private String name;              // Product Name
    private String shortCode;         // Short Code
    private String contents;          // Contents

    // COMPANY DETAILS
    private String companyName;
    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String shortName;
    private String manufacturer;

    // CATEGORY / FORM
    private String category;
    private String form;

    // PACKING / UNIT
    private String packing;
    private Integer unitQty;
    private String unitType;

    // STOCK LEVEL
    private Integer minLevel;
    private Integer maxLevel;

    // DISCOUNT
    private String cashDiscount;      // Y/N
    private Double discountPercent;

    // TAX
    private Double gstPercent;
    private String gstOn;             // ON PURCHASE RATE / SALE RATE
    private Double cess;

    // BILL SETTINGS
    private String billStatus;        // Y/N
    private String looseSale;         // Y/N

    // HSN
    private String hsnCode;
private String barcode;
    public Product(Long id, Long appid, String name, String shortCode, String contents, String companyName,
		String shortName, String manufacturer, String category, String form, String packing, Integer unitQty,
		String unitType, Integer minLevel, Integer maxLevel, String cashDiscount, Double discountPercent,
		Double gstPercent, String gstOn, Double cess, String billStatus, String looseSale, String hsnCode,
		String barcode, String imagePath, List<Batch> batches) {
	super();
	this.id = id;
	this.appid = appid;
	this.name = name;
	this.shortCode = shortCode;
	this.contents = contents;
	this.companyName = companyName;
	this.shortName = shortName;
	this.manufacturer = manufacturer;
	this.category = category;
	this.form = form;
	this.packing = packing;
	this.unitQty = unitQty;
	this.unitType = unitType;
	this.minLevel = minLevel;
	this.maxLevel = maxLevel;
	this.cashDiscount = cashDiscount;
	this.discountPercent = discountPercent;
	this.gstPercent = gstPercent;
	this.gstOn = gstOn;
	this.cess = cess;
	this.billStatus = billStatus;
	this.looseSale = looseSale;
	this.hsnCode = hsnCode;
	this.barcode = barcode;
	this.imagePath = imagePath;
	this.batches = batches;
}
	public String getBarcode() {
	return barcode;
}
public void setBarcode(String barcode) {
	this.barcode = barcode;
}
	// IMAGE (optional)
    private String imagePath;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Batch> batches;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAppid() {
		return appid;
	}
	public void setAppid(Long appid) {
		this.appid = appid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public Integer getUnitQty() {
		return unitQty;
	}
	public void setUnitQty(Integer unitQty) {
		this.unitQty = unitQty;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public Integer getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}
	public Integer getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}
	public String getCashDiscount() {
		return cashDiscount;
	}
	public void setCashDiscount(String cashDiscount) {
		this.cashDiscount = cashDiscount;
	}
	public Double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Double getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(Double gstPercent) {
		this.gstPercent = gstPercent;
	}
	public String getGstOn() {
		return gstOn;
	}
	public void setGstOn(String gstOn) {
		this.gstOn = gstOn;
	}
	public Double getCess() {
		return cess;
	}
	public void setCess(Double cess) {
		this.cess = cess;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getLooseSale() {
		return looseSale;
	}
	public void setLooseSale(String looseSale) {
		this.looseSale = looseSale;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	
}