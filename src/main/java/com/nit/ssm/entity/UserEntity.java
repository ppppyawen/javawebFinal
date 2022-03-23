package com.nit.ssm.entity;

public class UserEntity {
    private Integer userId;
    private Integer userStatus;
    private Integer userType;
    private String userCard;
    private String userName;
    private String userPhone;
    private String userPwd;

    public UserEntity(){

    }
    public UserEntity(Integer userId, Integer userStatus, Integer userType, String userCard, String userName, String userPhone, String userPwd){
        this.userId = userId;
        this.userStatus = userStatus;
        this.userType = userType;
        this.userCard = userCard;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPwd = userPwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}

