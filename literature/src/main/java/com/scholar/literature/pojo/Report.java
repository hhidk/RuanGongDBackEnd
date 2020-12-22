package com.scholar.literature.pojo;

import lombok.Data;

@Data
public class Report {
    private int reportID;
    private int type;
    private String content;
    private int status;
    private String reporterID;
    private String reporteeID;
    private String title;

    public Report(String reporterID, String reporteeID, String title, String content) {
        this.reporterID = reporterID;
        this.reporteeID = reporteeID;
        this.content = content;
        this.title = title;
        this.status = 0;
    }
}
