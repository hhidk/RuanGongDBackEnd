package com.scholar.root.dto;

import lombok.Data;

@Data
public class CommentReport
{
    String commentContent;
    String commentID;
    boolean hasRead;
    UserInfo reporterInfo;
    String reportContent;
    String reportID;
}
