package com.scholar.social.util;

import java.util.List;

public class Sector {
    private int id;
    private String name;
    private List<String> tags;
    private int tot;
    private Post post;

    public int getId() {
        return id;
    }

    public Sector setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sector setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public Sector setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public int getTot() {
        return tot;
    }

    public Sector setTot(int tot) {
        this.tot = tot;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Sector setPost(Post post) {
        this.post = post;
        return this;
    }
}
