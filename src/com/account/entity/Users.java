package com.account.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author Neal
 */
public class Users implements Serializable {
    private Integer userId;

    private String userName;

    private String userAvatar;

    private String userPassword;

    private String userSex;

    private String userPhonenum;

    private String userSignature;

    private String userEmail;

    private Timestamp registerDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserPhonenum() {
        return userPhonenum;
    }

    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum == null ? null : userPhonenum.trim();
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhonenum='" + userPhonenum + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}