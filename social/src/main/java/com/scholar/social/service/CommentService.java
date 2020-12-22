package com.scholar.social.service;

import com.scholar.social.repository.CommentRepository;
import com.scholar.social.repository.ReportRepository;
import com.scholar.social.util.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ReportRepository reportRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          ReportRepository reportRepository) {
        this.commentRepository = commentRepository;
        this.reportRepository = reportRepository;
    }

    public boolean put(String userId, int postId, String content) {
        commentRepository.insert(userId, String.valueOf(postId), content);
        return true;
    }

    public boolean report(String userId, int commentId, String content) {
        Comment comment = commentRepository.select(commentId);
        reportRepository
                .report(2, content, String.valueOf(commentId), userId, comment.getContent());
        return true;
    }

    public boolean delete(String userId, int commentId) {
        commentRepository.delete(userId, commentId);
        return true;
    }
}
