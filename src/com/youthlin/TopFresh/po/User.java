package com.youthlin.TopFresh.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lin on 2016-05-02-002.
 * 用户信息
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    @ElementCollection
    private Set<String> userAddress = new HashSet<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<String> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Set<String> userAddress) {
        this.userAddress = userAddress;
    }
}
