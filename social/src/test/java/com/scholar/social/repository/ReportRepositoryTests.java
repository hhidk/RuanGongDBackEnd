package com.scholar.social.repository;

import com.scholar.social.service.CommentService;
import com.scholar.social.service.PostService;
import com.scholar.social.util.Comment;
import com.scholar.social.util.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReportRepositoryTests {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    private int prePostId;
    private int preCommentId;

    // TODO test
    @BeforeEach
    void preTest() {
        Post post = new Post()
                .setContent("bbb")
                .setSectorId(1)
                .setUserId("9474EA29")
                .setTitle("QTitle");
        postRepository.put(post);
        int postId = post.getPostId();
        postRepository.putTags(postId, "pTagA;pTagB;pTagE");
        prePostId = postId;
        commentRepository.insert("9474EA29", String.valueOf(prePostId), "1");
        List<Comment> comments;
        comments = commentRepository.selectByPostId(String.valueOf(prePostId));
        preCommentId = comments.get(0).getId();
    }

    @AfterEach
    void postTest() {
        postRepository.delete(prePostId);
        commentRepository.deleteByPostId(String.valueOf(prePostId));
    }

    @Test
    void testReport() {
        postService.report("9474EA29", prePostId, "???");
        commentService.report("9474EA29", preCommentId, "XXX");
    }
}
