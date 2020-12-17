package com.scholar.social.util;

import java.util.Date;

public class Comment {
    private int id;
    private String userId;
    private String content;
    private Date time;

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
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public Comment setTime(Date time) {
        this.time = time;
        return this;
    }
}
