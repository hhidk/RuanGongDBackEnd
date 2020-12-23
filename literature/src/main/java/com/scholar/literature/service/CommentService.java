package com.scholar.literature.service;

import com.scholar.literature.mapper.CommentMapper;
import com.scholar.literature.mapper.UserMapper;
import com.scholar.literature.pojo.Comment;
import com.scholar.literature.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    public int comment(String userID, String literatureID, String content) throws Exception {
        Comment comment = new Comment(content, literatureID, userID);
        comment.setType(1);
        commentMapper.addComment(comment);
        return 0;
    }

    public List<Comment> getComment(String literatureID) {
        List<Comment> list = commentMapper.getCommentByLiteratureID(literatureID);
        for (Comment comment : list) {
            User user = userMapper.getUserByUserID(comment.getUserID());
            comment.setUsername(user.getUsername());
            comment.setImage(user.getImage());
        }
        return list;
    }

}
