package com.sonder.as1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity(name = "Users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT NULL")
    private String address;
    @Column(unique = true)
    @Email
    private String email;
    @Size(min = 5)
    private String fullName;
    @Column(columnDefinition = "TEXT NULL")
    private String note;
    private String password;
    @Size(min = 8, max = 12)
    private String phoneNumber;
    private Integer status = 1;
    @Column(unique = true)
    private String username;
    private LocalDate created = LocalDate.now();
    private String role = "USER";
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<UserDonation> userDonations;

    public User() {
    }

    public User(String address, String email, String fullName, String note, String password, String phoneNumber, Integer status, String username, LocalDate created, String role, Collection<UserDonation> userDonations) {
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.note = note;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.username = username;
        this.created = created;
        this.role = role;
        this.userDonations = userDonations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<UserDonation> getUserDonations() {
        return userDonations;
    }

    public void setUserDonations(Collection<UserDonation> userDonations) {
        this.userDonations = userDonations;
    }
}
