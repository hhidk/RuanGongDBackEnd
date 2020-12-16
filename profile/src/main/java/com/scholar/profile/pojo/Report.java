package com.scholar.profile.pojo;

import lombok.Data;

@Data
public class Report {
    private int reportID;
    private int type;
    private String content;
    private int status;
    private String adminID;
    private String reply;
    private String reporterID;
    private String reporteeID;
}
