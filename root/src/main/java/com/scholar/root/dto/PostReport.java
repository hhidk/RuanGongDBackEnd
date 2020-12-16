package com.scholar.root.dto;

import lombok.Data;

@Data
public class PostReport
{
    boolean hasRead;
    boolean isTrimmed;
    UserInfo reporterInfo;
    String reportContent;
    int reportID;
    String strPostID;
    int postID;
    String postContent;
    String trimmedContent;
}
