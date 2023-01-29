package com.sonder.as1.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;

@Table(name = "user_donation")
@Entity
public class UserDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate created = LocalDate.now();
    private Long money = 0L;
    private String name = "unknown";
    private Integer status = 1;
    @Column(columnDefinition = "TEXT NULL")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;

    public UserDonation() {
    }

    public UserDonation(LocalDate created, Long money, String name, Integer status, String text, User user, Donation donation) {
        this.created = created;
        this.money = money;
        this.name = name;
        this.status = status;
        this.text = text;
        this.user = user;
        this.donation = donation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }
}
