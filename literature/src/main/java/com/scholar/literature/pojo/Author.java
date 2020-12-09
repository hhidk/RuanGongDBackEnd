package com.scholar.literature.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private String authorID;
    private String name;
    private String organization;
}
