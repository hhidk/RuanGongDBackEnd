package com.scholar.profile.dto;

import lombok.Data;

@Data
public class UserPreview {
    private String userID;
    private String authorID;
    private int userIdentity;
    private String username;
    private String realName;
    private String image;
    private int userDegree;
    private String organization;
    private String emailAddress;
    private String phoneNumber;
    private String introduction;
}
