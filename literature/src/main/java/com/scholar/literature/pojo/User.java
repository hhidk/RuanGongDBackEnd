package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // 未认领的门户拥有的信息
    private String authorID;
    private String realName;
    private String organization;

    // 认领后的门户拥有的信息
    private String userID;
    private int userIdentity;
    private String username;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private String image;
    private String introduction;
    private int userDegree;

    public User(String authorID, String realName, String organization) {
        this.authorID = authorID;
        this.realName = realName;
        this.organization = organization;
    }

    public User(int init) {
        this.userID = null;
        this.userIdentity = 0;
        this.username = "未认领";
        this.password = null;
        this.phoneNumber = "未知";
        this.emailAddress = "未知";
        this.image = "http://60.205.189.66:8082/image/deadline2.jpg";
        this.introduction = "暂无";
        this.userDegree = 0;
    }
}
