package com.billingsoftware.app.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bill")
public class PurchaseBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gstNo;
    private Double sgstPercent;
    private Double cgstPercent;
    private String billNo;
    private String transactionType;
    private String billDate;
    private String dueDate;
    private Double outstandingAmount;
    private Integer totalItem;
    private Integer totalQuantity;
    private Double gst;
    private Double totalReplace;
    private Double totalFree;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToMany
    @JoinTable(
            name = "bill_products",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> items;

    public PurchaseBill() {}

	public PurchaseBill(Long id, String gstNo, Double sgstPercent, Double cgstPercent, String billNo,
			String transactionType, String billDate, String dueDate, Double outstandingAmount, Integer totalItem,
			Integer totalQuantity, Double gst, Double totalReplace, Double totalFree, Double totalAmount, Party party,
			List<Product> items) {
		super();
		this.id = id;
		this.gstNo = gstNo;
		this.sgstPercent = sgstPercent;
		this.cgstPercent = cgstPercent;
		this.billNo = billNo;
		this.transactionType = transactionType;
		this.billDate = billDate;
		this.dueDate = dueDate;
		this.outstandingAmount = outstandingAmount;
		this.totalItem = totalItem;
		this.totalQuantity = totalQuantity;
		this.gst = gst;
		this.totalReplace = totalReplace;
		this.totalFree = totalFree;
		this.totalAmount = totalAmount;
		this.party = party;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Double getSgstPercent() {
		return sgstPercent;
	}

	public void setSgstPercent(Double sgstPercent) {
		this.sgstPercent = sgstPercent;
	}

	public Double getCgstPercent() {
		return cgstPercent;
	}

	public void setCgstPercent(Double cgstPercent) {
		this.cgstPercent = cgstPercent;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getTotalReplace() {
		return totalReplace;
	}

	public void setTotalReplace(Double totalReplace) {
		this.totalReplace = totalReplace;
	}

	public Double getTotalFree() {
		return totalFree;
	}

	public void setTotalFree(Double totalFree) {
		this.totalFree = totalFree;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "PurchaseBill [id=" + id + ", gstNo=" + gstNo + ", sgstPercent=" + sgstPercent + ", cgstPercent="
				+ cgstPercent + ", billNo=" + billNo + ", transactionType=" + transactionType + ", billDate=" + billDate
				+ ", dueDate=" + dueDate + ", outstandingAmount=" + outstandingAmount + ", totalItem=" + totalItem
				+ ", totalQuantity=" + totalQuantity + ", gst=" + gst + ", totalReplace=" + totalReplace
				+ ", totalFree=" + totalFree + ", totalAmount=" + totalAmount + ", party=" + party + ", items=" + items
				+ "]";
	}

    // Getters & Setters
}
