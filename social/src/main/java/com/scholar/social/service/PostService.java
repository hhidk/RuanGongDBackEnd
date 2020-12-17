package com.scholar.social.service;

import com.scholar.social.repository.CommentRepository;
import com.scholar.social.repository.PostRepository;
import com.scholar.social.repository.ReportRepository;
import com.scholar.social.util.Post;
import com.scholar.social.util.PostFormatHelper;
import com.scholar.social.util.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(ReportRepository reportRepository,
                       PostRepository postRepository,
                       CommentRepository commentRepository) {
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public int put(Post post) {
        int postId = postRepository.put(post);
        postRepository.putTags(postId, String.join(";", post.getTags()));
        return postId;
    }

    public boolean delete(String userId, int postId) {
        commentRepository.deleteByPostId(postId);
        postRepository.delete(postId);
        return true;
    }

    public boolean report(String userId, int postId, String content) {
        reportRepository.report(3, content, String.valueOf(postId), userId);
        return true;
    }

    public List<Post> search(int sectorId, int start, int num, SortType sort, String keyword) {
        List<Post> postList = postRepository.search(sectorId, keyword);
        postList = postList.stream().map(this::getFullPostInfo).collect(Collectors.toList());
        switch (sort) {
            case TITLE:
                postList.sort(Comparator.comparing(Post::getTitle));
                break;
            case CREATE_TIME:
                postList.sort(Comparator.comparingLong(post -> post.getCreateTime().getTime()));
                break;
            case UPDATE_TIME:
                postList = postList.stream().map(PostFormatHelper::new)
                        .sorted(Comparator.comparingLong(p ->
                                p.getLastTime().getTime()
                        ))
                        .map(PostFormatHelper::getPost)
                        .collect(Collectors.toList());
                break;
            case REPLY_NUM:
                postList.sort(Comparator.comparingInt(post -> post.getComments().size()));
                break;
        }
        return postList.subList(start, Math.min(postList.size(), start + num));
    }

    private Post getFullPostInfo(Post post) {
        int postId = post.getPostId();
        post.setComments(commentRepository.selectByPostId(postId));
        String tags = postRepository.getTags(postId);
        post.setTags(Arrays.asList(tags.split(";")));
        return post;
    }

    public Post get(String userId, int postId) {
        postRepository.updateTimes(postId);
        Post post = postRepository.get(postId);
        return getFullPostInfo(post);
    }
}
