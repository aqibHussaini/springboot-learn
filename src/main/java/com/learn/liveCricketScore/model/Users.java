package com.learn.liveCricketScore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Users {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    int userid;
    @Column
    String username;
    @Column
    String email;
    @Column
    String address;

    @OneToMany(mappedBy = "userId")
    private List<Orders> orders;

    public Users() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
