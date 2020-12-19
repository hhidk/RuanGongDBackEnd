package com.scholar.literature.controller;

import com.scholar.literature.pojo.Comment;
import com.scholar.literature.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment")
    public int comment(@RequestParam("userID") String userID, @RequestParam("literatureID") String literatureID,
                       @RequestParam("content") String content) throws Exception {
        try {
            return commentService.comment(userID, literatureID, content);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/getComment")
    public List<Comment> getComment(String literatureID) {
        try {
            return commentService.getComment(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
