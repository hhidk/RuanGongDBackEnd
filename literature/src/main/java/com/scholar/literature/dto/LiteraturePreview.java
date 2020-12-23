package com.scholar.literature.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LiteraturePreview {
    private String literatureID;
    private String title;
    private String collectTime;
    private String year;
    private String venue;
    private String realName;
    private List<Map> authors;
    private int citation;
}
