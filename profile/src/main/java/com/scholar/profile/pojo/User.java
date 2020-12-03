package com.scholar.profile.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    }
}
