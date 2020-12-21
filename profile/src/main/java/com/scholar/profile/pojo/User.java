package com.scholar.profile.pojo;

import lombok.Data;

@Data
public class User {
    private String userID;
    private int userIdentity;
    private String username;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private String image;
    private String organization;
    private String introduction;
    private String realName;
    private int userDegree;

    public User(){ }

    public User(String userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userIdentity = 0;
        this.phoneNumber = "保密";
        this.emailAddress = "保密";
        this.organization = "保密";
        this.introduction = "暂未填写";
        this.realName = "保密";
        this.userDegree = 0;
    }
}
