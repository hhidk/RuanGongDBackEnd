package com.scholar.literature.service;

import com.scholar.literature.mapper.CommentMapper;
import com.scholar.literature.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public int comment(String userID, String literatureID, String content) throws Exception {
        Comment comment = new Comment(content, literatureID, userID);
        comment.setType(1);
        commentMapper.addComment(comment);
        return 0;
    }

    public List<Comment> getComment(String literatureID) {
        return commentMapper.getCommentByLiteratureID(literatureID);
    }

}
