package com.scholar.social.util;

import java.util.List;

public class Post {
    List<String> tags;
    int citeId;
    List<Comment> comments;
    private String userId;
    private String title;
    private String content;
    private String userName;
    private String userAvatar;
    private int viewNum;
    private long createTime;
    private int sectorId;

    public String getUserName() {
        return userName;
    }

    public Post setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public Post setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
        return this;
    }

    public int getViewNum() {
        return viewNum;
    }

    public Post setViewNum(int viewNum) {
        this.viewNum = viewNum;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Post setCreateTime(long createTime) {
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
