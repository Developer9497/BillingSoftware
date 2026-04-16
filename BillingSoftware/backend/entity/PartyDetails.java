//package com.restaurant.app.Restaurant.backend.entity;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//@Entity
////@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class PartyDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String vouNo;
//    private String vouDate;
//    private String partyName;
//    private String addressLine1;
//    private String addressLine2;
//    private String telephone;
//    private String faxNumber;
//    private String mobile;
//    private String email;
//    private String contactPerson;
//    private String dlRegNo;
//    private String vatTin;
//    private String panNo;
//    private String gstNo;
//    private Double sgstPercent;
//    private Double cgstPercent;
//    private String billNo;
//    private String transactionType;
//    private String billDate;
//    private String dueDate;
//    private Double outstandingAmount;
//    private String isDataOk;
////    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
////    @JsonManagedReference // <--- Annotation for the 'managed' side (parent)
////    private List<Product> items;
////    // -------------------- Getters & Setters --------------------
//
// // A Supplier (Party) has many PurchaseInvoices.
//    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<PurchaseInvoice> invoices; // Use 'invoices' list of type 'PurchaseInvoice'
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getVouNo() {
//		return vouNo;
//	}
//
//	public void setVouNo(String vouNo) {
//		this.vouNo = vouNo;
//	}
//
//	public String getVouDate() {
//		return vouDate;
//	}
//
//	public void setVouDate(String vouDate) {
//		this.vouDate = vouDate;
//	}
//
//	public String getPartyName() {
//		return partyName;
//	}
//
//	public void setPartyName(String partyName) {
//		this.partyName = partyName;
//	}
//
//	public String getAddressLine1() {
//		return addressLine1;
//	}
//
//	public void setAddressLine1(String addressLine1) {
//		this.addressLine1 = addressLine1;
//	}
//
//	public String getAddressLine2() {
//		return addressLine2;
//	}
//
//	public void setAddressLine2(String addressLine2) {
//		this.addressLine2 = addressLine2;
//	}
//
//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
//
//	public String getFaxNumber() {
//		return faxNumber;
//	}
//
//	public void setFaxNumber(String faxNumber) {
//		this.faxNumber = faxNumber;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getContactPerson() {
//		return contactPerson;
//	}
//
//	public void setContactPerson(String contactPerson) {
//		this.contactPerson = contactPerson;
//	}
//
//	public String getDlRegNo() {
//		return dlRegNo;
//	}
//
//	public void setDlRegNo(String dlRegNo) {
//		this.dlRegNo = dlRegNo;
//	}
//
//	public String getVatTin() {
//		return vatTin;
//	}
//
//	public void setVatTin(String vatTin) {
//		this.vatTin = vatTin;
//	}
//
//	public String getPanNo() {
//		return panNo;
//	}
//
//	public void setPanNo(String panNo) {
//		this.panNo = panNo;
//	}
//
//	public String getGstNo() {
//		return gstNo;
//	}
//
//	public void setGstNo(String gstNo) {
//		this.gstNo = gstNo;
//	}
//
//	public Double getSgstPercent() {
//		return sgstPercent;
//	}
//
//	public void setSgstPercent(Double sgstPercent) {
//		this.sgstPercent = sgstPercent;
//	}
//
//	public Double getCgstPercent() {
//		return cgstPercent;
//	}
//
//	public void setCgstPercent(Double cgstPercent) {
//		this.cgstPercent = cgstPercent;
//	}
//
//	public String getBillNo() {
//		return billNo;
//	}
//
//	public void setBillNo(String billNo) {
//		this.billNo = billNo;
//	}
//
//	public String getTransactionType() {
//		return transactionType;
//	}
//
//	public void setTransactionType(String transactionType) {
//		this.transactionType = transactionType;
//	}
//
//	public String getBillDate() {
//		return billDate;
//	}
//
//	public void setBillDate(String billDate) {
//		this.billDate = billDate;
//	}
//
//	public String getDueDate() {
//		return dueDate;
//	}
//
//	public void setDueDate(String dueDate) {
//		this.dueDate = dueDate;
//	}
//
//	public Double getOutstandingAmount() {
//		return outstandingAmount;
//	}
//
//	public void setOutstandingAmount(Double outstandingAmount) {
//		this.outstandingAmount = outstandingAmount;
//	}
//
//	public String getIsDataOk() {
//		return isDataOk;
//	}
//
//	public void setIsDataOk(String isDataOk) {
//		this.isDataOk = isDataOk;
//	}
//
//	public List<PurchaseInvoice> getInvoices() {
//		return invoices;
//	}
//
//	public void setInvoices(List<PurchaseInvoice> invoices) {
//		this.invoices = invoices;
//	}
//
//	
//
//	public PartyDetails() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public PartyDetails(Long id, String vouNo, String vouDate, String partyName, String addressLine1,
//			String addressLine2, String telephone, String faxNumber, String mobile, String email, String contactPerson,
//			String dlRegNo, String vatTin, String panNo, String gstNo, Double sgstPercent, Double cgstPercent,
//			String billNo, String transactionType, String billDate, String dueDate, Double outstandingAmount,
//			String isDataOk, List<PurchaseInvoice> invoices) {
//		super();
//		this.id = id;
//		this.vouNo = vouNo;
//		this.vouDate = vouDate;
//		this.partyName = partyName;
//		this.addressLine1 = addressLine1;
//		this.addressLine2 = addressLine2;
//		this.telephone = telephone;
//		this.faxNumber = faxNumber;
//		this.mobile = mobile;
//		this.email = email;
//		this.contactPerson = contactPerson;
//		this.dlRegNo = dlRegNo;
//		this.vatTin = vatTin;
//		this.panNo = panNo;
//		this.gstNo = gstNo;
//		this.sgstPercent = sgstPercent;
//		this.cgstPercent = cgstPercent;
//		this.billNo = billNo;
//		this.transactionType = transactionType;
//		this.billDate = billDate;
//		this.dueDate = dueDate;
//		this.outstandingAmount = outstandingAmount;
//		this.isDataOk = isDataOk;
//		this.invoices = invoices;
//	}
//    
////    public List<Product> getItems() {
////		return items;
////	}
//
//
//}
