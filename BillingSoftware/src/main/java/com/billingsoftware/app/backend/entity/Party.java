package com.billingsoftware.app.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "party")
public class Party {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	
	    private String partyName;
	    private String addressLine1;
	    private String addressLine2;
	    private String telephone;
	    private String faxNumber;
	    private String mobile;
	    private String email;
	    private String contactPerson;
	    private String dlRegNo;
	    private String vatTin;
	    private String panNo;
	    private String gstNo;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getPartyName() {
			return partyName;
		}
		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getFaxNumber() {
			return faxNumber;
		}
		public void setFaxNumber(String faxNumber) {
			this.faxNumber = faxNumber;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContactPerson() {
			return contactPerson;
		}
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}
		public String getDlRegNo() {
			return dlRegNo;
		}
		public void setDlRegNo(String dlRegNo) {
			this.dlRegNo = dlRegNo;
		}
		public String getVatTin() {
			return vatTin;
		}
		public void setVatTin(String vatTin) {
			this.vatTin = vatTin;
		}
		public String getPanNo() {
			return panNo;
		}
		public void setPanNo(String panNo) {
			this.panNo = panNo;
		}
		public String getGstNo() {
			return gstNo;
		}
		public void setGstNo(String gstNo) {
			this.gstNo = gstNo;
		}
		public Party(Long id, String vouNo, String vouDate, String partyName, String addressLine1, String addressLine2,
				String telephone, String faxNumber, String mobile, String email, String contactPerson, String dlRegNo,
				String vatTin, String panNo, String gstNo) {
			super();
			this.id = id;
			
			this.partyName = partyName;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.telephone = telephone;
			this.faxNumber = faxNumber;
			this.mobile = mobile;
			this.email = email;
			this.contactPerson = contactPerson;
			this.dlRegNo = dlRegNo;
			this.vatTin = vatTin;
			this.panNo = panNo;
			this.gstNo = gstNo;
		}
		public Party() {
			super();
			// TODO Auto-generated constructor stub
		}

   
}
