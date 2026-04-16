package com.billingsoftware.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    // Many users belong to one shop
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "role", nullable = false)
    private String role; // e.g., Admin, Manager, Staff

    @Column(name = "user_register_date", nullable = false)
    private LocalDate userRegisterDate;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_contact")
    private String userContact;

    @Column(name = "user_gmail", unique = true, nullable = false)
    private String userGmail;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_status", nullable = false)
    private String userStatus; // Active, Inactive

    @Column(name = "password", nullable = false)
    private String password; // Encrypted password

    public User() {}

    public User(Long uid, Shop shop, String role, LocalDate userRegisterDate, String userName,
                String userContact, String userGmail, String userAddress, String userStatus, String password) {
        this.uid = uid;
        this.shop = shop;
        this.role = role;
        this.userRegisterDate = userRegisterDate;
        this.userName = userName;
        this.userContact = userContact;
        this.userGmail = userGmail;
        this.userAddress = userAddress;
        this.userStatus = userStatus;
        this.password = password;
    }

    // --- Getters & Setters ---
    public Long getUid() { return uid; }
    public void setUid(Long uid) { this.uid = uid; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDate getUserRegisterDate() { return userRegisterDate; }
    public void setUserRegisterDate(LocalDate userRegisterDate) { this.userRegisterDate = userRegisterDate; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserContact() { return userContact; }
    public void setUserContact(String userContact) { this.userContact = userContact; }

    public String getUserGmail() { return userGmail; }
    public void setUserGmail(String userGmail) { this.userGmail = userGmail; }

    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public String getUserStatus() { return userStatus; }
    public void setUserStatus(String userStatus) { this.userStatus = userStatus; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
