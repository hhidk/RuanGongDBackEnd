package com.scholar.social.service;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public boolean put(int userId, int postId, String content) {
        // TODO call repository
        return false;
    }

    public boolean report(int userId, int commentId, String content) {
        // TODO call repository
        return false;
    }

    public boolean delete(int userId, int commentId) {
        // TODO call repository
        return false;
    }
}
