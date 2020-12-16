package com.scholar.social.util;

import java.util.Date;
import java.util.List;

public class Post {
    int postId;
    List<String> tags;
    int citeId;
    List<Comment> comments;
    private String userId;
    private String title;
    private String content;
    private int viewNum;
    private Date createTime;
    private int sectorId;

    public int getPostId() {
        return postId;
    }

    public Post setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    public int getViewNum() {
        return viewNum;
    }

    public Post setViewNum(int viewNum) {
        this.viewNum = viewNum;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Post setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Post setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public int getSectorId() {
        return sectorId;
    }

    public Post setSectorId(int sectorId) {
        this.sectorId = sectorId;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public Post setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public int getCiteId() {
        return citeId;
    }

    public Post setCiteId(int citeId) {
        this.citeId = citeId;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
