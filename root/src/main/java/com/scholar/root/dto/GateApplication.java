package com.scholar.root.dto;

import lombok.Data;

@Data
public class GateApplication
{
    int applicationID;
    String userID;
    String userName;
    String imgPath;
    String userDegree;
    String authorID;
    String emailAddress;
    Boolean isTrimmed;
    String content;
    String trimmedContent;
    int status;
    String realName;
}
