package com.scholar.literature.dto;

import lombok.Data;

import java.util.Map;

@Data
public class LiteraturePreview {
    private String literatureID;
    private String title;
    private String collectTime;
    private String year;
    private String venue;
    private String realName;
    private Map authors;
    private int citation;
}
