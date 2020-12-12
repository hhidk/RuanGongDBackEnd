package com.scholar.social.service;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public boolean put(String userId, int postId, String content) {
        // TODO call repository
        return false;
    }

    public boolean report(String userId, int commentId, String content) {
        // TODO call repository
        return false;
    }

    public boolean delete(String userId, int commentId) {
        // TODO call repository
        return false;
    }
}
