package com.scholar.root.dto;

import lombok.Data;

@Data
public class ArticleReport
{
    String articleID;
    String articleTitle;
    boolean hasRead;
    boolean isTrimmed;
    String reportContent;
    String reportID;
    UserInfo reporterInfo;
    String trimmedContent;
}
