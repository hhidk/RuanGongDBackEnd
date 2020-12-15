package com.scholar.literature.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Author {
    private int h_index;
    private String id;
    private int n_citation;
    private int n_pubs;
    private String name;
    private String orgs;
    private String position;
    private List<Pub> pubs;
    private List<Tag> tags;
}
