package com.scholar.root.dto;

import lombok.Data;

@Data
public class CommentReport
{
    String commentContent;
    int commentID;
    boolean hasRead;
    boolean isTrimmed;
    UserInfo reporterInfo;
    String reportContent;
    int reportID;
    String trimmedContent;
}
