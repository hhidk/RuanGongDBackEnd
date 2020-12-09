package com.scholar.root.dto;

import lombok.Data;

@Data
public class ArticleReport
{
    String articleID;
    String articleTitle;
    boolean hasRead;
    String reportContent;
    String reportID;
    UserInfo reporterInfo;
}
