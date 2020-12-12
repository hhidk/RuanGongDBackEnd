package com.scholar.root.dto;

import lombok.Data;

@Data
public class GateReport
{
    boolean hasRead;
    boolean isTrimmed;
    UserInfo reporteeInfo;
    UserInfo reporterInfo;
    String reportContent;
    String reportID;
    String trimmedContent;
}
