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
    @Column(unique = true)
    @Email(message = "Email không hợp lệ")
    @NotBlank
    private String email;
    @Size(min = 8,message = "Mật khẩu phải nhiều hơn 8 ký tự")
    @NotBlank
    private String password;
    @Enumerated(EnumType.STRING)
    private ERole role = ERole.ROLE_USER;
    @NotNull
    private String fullName;
    @Column(columnDefinition = "TEXT NULL")
    private String address;
    @Column(columnDefinition = "TEXT NULL")
    private String note;
    @Size(min = 8, max = 12,message = "Số điện thoại lớn hơn 8 và nhỏ hơn 12")
    private String phoneNumber;
    private Integer status = 1;
    private LocalDate created = LocalDate.now();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<UserDonation> userDonations;

    public User() {
    }

    public User(String email, String password, ERole role, String fullName, String address, String note, String phoneNumber, Integer status, LocalDate created, Collection<UserDonation> userDonations) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.address = address;
        this.note = note;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.created = created;
        this.userDonations = userDonations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Collection<UserDonation> getUserDonations() {
        return userDonations;
    }

    public void setUserDonations(Collection<UserDonation> userDonations) {
        this.userDonations = userDonations;
    }
}
