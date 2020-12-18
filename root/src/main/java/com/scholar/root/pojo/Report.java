package com.scholar.root.pojo;

import lombok.Data;

@Data
public class Report
{
    String reportID;
    int type;
    String content;
    boolean status;
    String title;
    String reporteeID;
    String reporterID;
}
