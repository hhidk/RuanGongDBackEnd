package com.scholar.social.service;

import com.scholar.social.repository.CommentRepository;
import com.scholar.social.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private ReportRepository reportRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public boolean put(String userId, int postId, String content) {
        commentRepository.insert(userId, postId, content);
        return true;
    }

    public boolean report(String userId, int commentId, String content) {
        reportRepository.report(2, content, String.valueOf(commentId), userId);
        return true;
    }

    public boolean delete(String userId, int commentId) {
        commentRepository.delete(userId, commentId);
        return true;
    }
}
