package com.scholar.literature.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Document(indexName = "author")
public class Author implements Serializable {
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
