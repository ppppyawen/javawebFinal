package com.nit.ssm.dto;

public class LoginDTO {
    private Integer userId;
    private String userName;
    private Integer userStatus;
    private Integer userType;
    private String userPhone;
    private String userPwd;
    private String verifyCode;


    private boolean Administrator_login;

    public LoginDTO() {
    }

    public LoginDTO(Integer userId, String userName, Integer userStatus, Integer userType, String userPhone, String userPwd, String verifyCode, boolean administrator_login) {
        this.userId = userId;
        this.userName = userName;
        this.userStatus = userStatus;
        this.userType = userType;
        this.userPhone = userPhone;
        this.userPwd = userPwd;
        this.verifyCode = verifyCode;
        Administrator_login = administrator_login;
    }

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

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isAdministrator_login() {
        return Administrator_login;
    }

    public void setAdministrator_login(boolean administrator_login) {
        Administrator_login = administrator_login;
    }
}
