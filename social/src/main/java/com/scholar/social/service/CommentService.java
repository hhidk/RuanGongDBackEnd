package com.scholar.social.service;

import com.scholar.social.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public boolean put(String userId, int postId, String content) {
        commentRepository.insert(userId, postId, content);
        return true;
    }

    public boolean report(String userId, int commentId, String content) {
        // TODO call repository
        return false;
    }

    public boolean delete(String userId, int commentId) {
        commentRepository.delete(userId, commentId);
        return true;
    }
}
