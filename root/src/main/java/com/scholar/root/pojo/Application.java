package com.scholar.root.pojo;

import lombok.Data;

@Data
public class Application
{
    int applicationID;
    String userID;
    String authorID;
    String emailAddress;
    String content;
    int status;
    String realName;
}
