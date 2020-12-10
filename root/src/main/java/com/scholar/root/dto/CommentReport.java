package com.scholar.root.dto;

import lombok.Data;

@Data
public class CommentReport
{
    String commentContent;
    String commentID;
    boolean hasRead;
    boolean isTrimmed;
    UserInfo reporterInfo;
    String reportContent;
    String reportID;
    String trimmedContent;
}
