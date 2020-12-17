package com.scholar.literature.pojo;

import java.io.Serializable;
import java.util.List;


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

    public void setH_index(int h_index) {
        this.h_index = h_index;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setN_citation(int n_citation) {
        this.n_citation = n_citation;
    }

    public void setN_pubs(int n_pubs) {
        this.n_pubs = n_pubs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrgs(String orgs) {
        this.orgs = orgs;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPubs(List<Pub> pubs) {
        this.pubs = pubs;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getH_index() {
        return h_index;
    }

    public String getId() {
        return id;
    }

    public int getN_citation() {
        return n_citation;
    }

    public int getN_pubs() {
        return n_pubs;
    }

    public String getName() {
        return name;
    }

    public String getOrgs() {
        return orgs;
    }

    public String getPosition() {
        return position;
    }

    public List<Pub> getPubs() {
        return pubs;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
