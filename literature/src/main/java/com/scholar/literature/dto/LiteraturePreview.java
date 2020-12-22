package com.scholar.literature.dto;

import lombok.Data;

@Data
public class LiteraturePreview {
    private String literatureID;
    private String title;
    private String collectTime;
    private String year;
    private String venue;
    private int collect;
}
