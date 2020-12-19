package com.scholar.profile.pojo;

import lombok.Data;

@Data
public class Report {
    private int reportID;
    private int type;
    private String content;
    private int status;
    private String reporterID;
    private String reporteeID;

    public Report(String reporterID, String reporteeID, String content) {
        this.reporterID = reporterID;
        this.reporteeID = reporteeID;
        this.content = content;
    }
}
