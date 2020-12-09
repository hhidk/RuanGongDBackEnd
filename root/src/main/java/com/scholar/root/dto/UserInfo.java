package com.scholar.root.dto;

import lombok.Data;

@Data
public class UserInfo
{
    String userID;
    boolean isAuthorized;
    String imgPath;
    String realName;
    String userJob;
}
