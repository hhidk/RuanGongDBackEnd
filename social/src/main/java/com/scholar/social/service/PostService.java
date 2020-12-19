package com.scholar.social.service;

import com.scholar.social.repository.*;
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
    private final SectorRepository sectorRepository;
    private final UserFollowRepository userFollowRepository;

    @Autowired
    public PostService(ReportRepository reportRepository,
                       PostRepository postRepository,
                       CommentRepository commentRepository,
                       SectorRepository sectorRepository,
                       UserFollowRepository userFollowRepository) {
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.sectorRepository = sectorRepository;
        this.userFollowRepository = userFollowRepository;
    }

    public int put(Post post) {
        postRepository.put(post);
        int postId = post.getPostId();
        postRepository.putTags(postId, String.join(";", post.getTags()));
        int sectorId = post.getSectorId();
        int tot = sectorRepository.getTot(sectorId) + 1;
        sectorRepository.setTot(sectorId, tot);
        return postId;
    }

    public boolean delete(String userId, int postId) {
        Post post = postRepository.get(postId);
        int sectorId = post.getSectorId();
        int tot = sectorRepository.getTot(sectorId) - 1;
        sectorRepository.setTot(sectorId, tot);
        commentRepository.deleteByPostId(postId);
        postRepository.delete(postId);
        return true;
    }

    public boolean report(String userId, int postId, String content) {
        Post post = postRepository.get(postId);
        reportRepository.report(3, content, String.valueOf(postId), userId, post.getContent());
        return true;
    }

    public List<Post> search(int sectorId, int start, int num, SortType sort, String keyword) {
        List<Post> postList = postRepository.search(sectorId, keyword);
        if (start >= postList.size()) {
            return List.of();
        }
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
        post.setComments(commentRepository.selectByPostId(String.valueOf(postId)));
        String tags = postRepository.getTags(postId);
        post.setTags(Arrays.asList(tags.split(";")));
        return post;
    }

    public Post get(String userId, int postId) {
        postRepository.updateTimes(postId);
        Post post = postRepository.get(postId);
        return getFullPostInfo(post);
    }

    public List<Post> getPostsByUserId(String userId) {
        List<Post> postList = postRepository.getByUserId(userId);
        postList = postList.stream().map(this::getFullPostInfo).collect(Collectors.toList());
        return postList;
    }

    public List<Post> getPostsByFollowing(String userId) {
        List<String> followingUserId = userFollowRepository.getFollowing(userId);
        return followingUserId.stream()
                .flatMap(id ->
                        postRepository.getByUserId(id).stream()
                )
                .map(this::getFullPostInfo)
                .collect(Collectors.toList());
    }
}
