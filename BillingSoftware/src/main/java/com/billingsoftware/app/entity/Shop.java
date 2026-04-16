package com.billingsoftware.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "shop_address")
    private String shopAddress;

    @Column(name = "shop_contact")
    private String shopContact;

    @Column(name = "shop_email")
    private String shopEmail;

    @Column(name = "shop_logo")
    private String shopLogo; // Can store file path or URL

    @Column(name = "shop_gstno")
    private String shopGstNo;

    @Column(name = "shop_payment_qr")
    private String shopPaymentQr; // File path or QR image URL

    @Column(name = "shop_img")
    private String shopImg; // Shop front image (path/URL)

    @Column(name = "shop_owner_name")
    private String shopOwnerName;

    @Column(name = "shop_register_date")
    private LocalDate shopRegisterDate;

    @Column(name = "shop_plan_date")
    private LocalDate shopPlanDate;

    @Column(name = "shop_plan_validity_days")
    private Integer shopPlanValidityDays; // e.g., 365 days

    @Column(name = "shop_plan_status")
    private String shopPlanStatus; // Active / Inactive

    // --- Constructors ---
    public Shop() {}

    public Shop(Long shopId, String shopName, String shopAddress, String shopContact, String shopEmail,
                String shopLogo, String shopGstNo, String shopPaymentQr, String shopImg,
                String shopOwnerName, LocalDate shopRegisterDate, LocalDate shopPlanDate,
                Integer shopPlanValidityDays, String shopPlanStatus) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopContact = shopContact;
        this.shopEmail = shopEmail;
        this.shopLogo = shopLogo;
        this.shopGstNo = shopGstNo;
        this.shopPaymentQr = shopPaymentQr;
        this.shopImg = shopImg;
        this.shopOwnerName = shopOwnerName;
        this.shopRegisterDate = shopRegisterDate;
        this.shopPlanDate = shopPlanDate;
        this.shopPlanValidityDays = shopPlanValidityDays;
        this.shopPlanStatus = shopPlanStatus;
    }

    // --- Getters & Setters ---
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopContact() {
        return shopContact;
    }
    public void setShopContact(String shopContact) {
        this.shopContact = shopContact;
    }

    public String getShopEmail() {
        return shopEmail;
    }
    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopLogo() {
        return shopLogo;
    }
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getShopGstNo() {
        return shopGstNo;
    }
    public void setShopGstNo(String shopGstNo) {
        this.shopGstNo = shopGstNo;
    }

    public String getShopPaymentQr() {
        return shopPaymentQr;
    }
    public void setShopPaymentQr(String shopPaymentQr) {
        this.shopPaymentQr = shopPaymentQr;
    }

    public String getShopImg() {
        return shopImg;
    }
    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopOwnerName() {
        return shopOwnerName;
    }
    public void setShopOwnerName(String shopOwnerName) {
        this.shopOwnerName = shopOwnerName;
    }

    public LocalDate getShopRegisterDate() {
        return shopRegisterDate;
    }
    public void setShopRegisterDate(LocalDate shopRegisterDate) {
        this.shopRegisterDate = shopRegisterDate;
    }

    public LocalDate getShopPlanDate() {
        return shopPlanDate;
    }
    public void setShopPlanDate(LocalDate shopPlanDate) {
        this.shopPlanDate = shopPlanDate;
    }

    public Integer getShopPlanValidityDays() {
        return shopPlanValidityDays;
    }
    public void setShopPlanValidityDays(Integer shopPlanValidityDays) {
        this.shopPlanValidityDays = shopPlanValidityDays;
    }

    public String getShopPlanStatus() {
        return shopPlanStatus;
    }
    public void setShopPlanStatus(String shopPlanStatus) {
        this.shopPlanStatus = shopPlanStatus;
    }
}
