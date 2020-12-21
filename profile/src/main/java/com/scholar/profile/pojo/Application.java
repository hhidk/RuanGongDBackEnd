package com.scholar.profile.pojo;

import lombok.Data;

@Data
public class Application {
    private int applicationID;
    private String userID;
    private String authorID;
    private int status;
    private String emailAddress;
    private String content;

    public Application(String userID, String authorID, String emailAddress, String content) {
        this.userID = userID;
        this.authorID = authorID;
        this.emailAddress = emailAddress;
        this.content = content;
        this.status = 0;
    }

}
