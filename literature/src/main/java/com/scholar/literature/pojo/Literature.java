package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Literature {
    private String id;
    private String title;
    private List<LitAuthor> authors;
    private String url;
    private String issue;
    private int n_citation;
    private List<String> keywords;
    private int page_start;
    private int page_end;
    private List<Venue> venues;
    private String volume;
    private int year;
}
