package com.sonder.as1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.sql.Date;
import java.util.Collection;

@Entity(name = "Donation")
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Column(columnDefinition = "TEXT NULL")
    private String description;
    @PastOrPresent
    private Date startDate;
    @FutureOrPresent
    private Date endDate;
    private String name;
    private Long money = 0L;
    @NotNull
    private String organizationName;

    private String phoneNumber;
    private Integer status = 1;
    @OneToMany(mappedBy = "donation",cascade = CascadeType.ALL)
    private Collection<UserDonation> userDonations;

    public Donation() {
    }

    public Donation(String code, String description, Date startDate, Date endDate, String name, Long money, String organizationName, String phoneNumber, Integer status, Collection<UserDonation> userDonations) {
        this.code = code;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.money = money;
        this.organizationName = organizationName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.userDonations = userDonations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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

    public Collection<UserDonation> getUserDonations() {
        return userDonations;
    }

    public void setUserDonations(Collection<UserDonation> userDonations) {
        this.userDonations = userDonations;
    }
}
