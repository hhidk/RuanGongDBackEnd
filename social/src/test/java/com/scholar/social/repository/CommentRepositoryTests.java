package com.scholar.social.repository;

import com.scholar.social.util.Comment;
import com.scholar.social.util.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class CommentRepositoryTests {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    private int prePostId;

    // TODO do time test
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
    }

    @AfterEach
    void postTest() {
        postRepository.delete(prePostId);
        commentRepository.deleteByPostId(String.valueOf(prePostId));
    }

    @Test
    void testModify() {
        List<Comment> comments;
        comments = commentRepository.selectByPostId(String.valueOf(prePostId));
        Assert.isTrue(comments.size() == 0, "failed");
        commentRepository.insert("9474EA29", String.valueOf(prePostId), "1");
        commentRepository.insert("9474EA29", String.valueOf(prePostId), "2");
        commentRepository.insert("9474EA29", String.valueOf(prePostId), "3");
        comments = commentRepository.selectByPostId(String.valueOf(prePostId));
        Assert.isTrue(comments.size() == 3, "failed in getByPostId");
        Comment comment = comments.get(0);
//        long current = System.currentTimeMillis();
//        Assert.isTrue(
//                Math.abs(comment.getTime().getTime() - current) <= 1000 * 60
//                , String.format("time wrong, current is %d but get %d, the difference is %d",
//                        current, comment.getTime().getTime(), comment.getTime().getTime() - current)
//        );
        commentRepository.delete("9474EA29", comment.getId());
        comments = commentRepository.selectByPostId(String.valueOf(prePostId));
        Assert.isTrue(comments.size() == 2, "failed");
        commentRepository.deleteByPostId(String.valueOf(prePostId));
        comments = commentRepository.selectByPostId(String.valueOf(prePostId));
        Assert.isTrue(comments.size() == 0, "failed");
    }
}
