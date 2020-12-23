package com.scholar.social.repository;

import com.scholar.social.util.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class PostRepositoryTests {
    @Autowired
    private PostRepository postRepository;
    private int prePostId;

    @BeforeEach
    void preparePost() {
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
    void clearPost() {
        postRepository.delete(prePostId);
    }

    @Test
    void testModify() {
        Post post = new Post()
                .setContent("aaa")
                .setSectorId(1)
                .setUserId("9474EA29")
                .setTitle("ZTitle");
        postRepository.put(post);
        int postId = post.getPostId();
        postRepository.putTags(postId, "pTagA;pTagB;pTagC");
        Post newPost = postRepository.get(post.getPostId());
        Assert.isTrue(newPost.getPostId() == postId,
                String.format("postId in put is %d, but in get is %d", postId,
                        newPost.getPostId()));
        postRepository.delete(postId);
    }

    @Test
    void testGet() {
        Post post = postRepository.get(prePostId);
        String tags = postRepository.getTags(post.getPostId());
        Assert.isNull(post.getCiteId(), "failed in citeId");
        Assert.isTrue(post.getPostId() == prePostId, "failed in postId");
        Assert.isTrue(post.getContent().equals("bbb"), "failed in content");
        Assert.isTrue(post.getTitle().equals("QTitle"), "failed in title");
        Assert.isTrue(post.getUserId().equals("9474EA29"), "failed in userId");
        Assert.isTrue(post.getSectorId() == 1, "failed in sectorId");
        Assert.isTrue(tags.equals("pTagA;pTagB;pTagE"), "failed in tags");
    }

    @Test
    void testTimes() {
        Post post = postRepository.get(prePostId);
        int before = post.getViewNum();
        postRepository.updateTimes(prePostId);
        post = postRepository.get(prePostId);
        int after = post.getViewNum();
        Assert.isTrue(before + 1 == after,
                String.format("failed in update, before is %d but after is %d", before, after));
    }

    @Test
    void testSearch() {
        Assert.isTrue(postRepository.search(1, "QT").size() == 1, "failed");
        Assert.isTrue(postRepository.search(1, "Tag").size() == 1, "failed");
        Assert.isTrue(postRepository.search(1, "pTagE").size() == 1, "failed");
        Assert.isTrue(postRepository.search(1, "pTagA").size() == 1, "failed");
        Assert.isTrue(postRepository.search(1, "pTagB").size() == 1, "failed");
        Assert.isTrue(postRepository.search(2, "QT").size() == 0, "failed");
        Assert.isTrue(postRepository.search(1, "QTT").size() == 0, "failed in search");
    }

    @Test
    void testGetByUserId() {
        Assert.isTrue(postRepository.getByUserId("9474EA29").size() == 1, "failed in getByUserId");
        Assert.isTrue(postRepository.getByUserId("3474EA29").size() == 0, "failed in getByUserId");
    }
}
