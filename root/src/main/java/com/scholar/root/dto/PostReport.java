package com.scholar.root.dto;

import lombok.Data;

@Data
public class PostReport
{
    boolean hasRead;
    boolean isTrimmed;
    UserInfo reporterInfo;
    String reportContent;
    String reportID;
    String postID;
    String postContent;
    String trimmedContent;
}
