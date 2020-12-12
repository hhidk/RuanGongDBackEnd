package com.scholar.social.util;

public class Comment {
    private int id;
    private String userId;
    private String Content;
    private long time;

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Comment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getContent() {
        return Content;
    }

    public Comment setContent(String content) {
        Content = content;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Comment setTime(long time) {
        this.time = time;
        return this;
    }
}
