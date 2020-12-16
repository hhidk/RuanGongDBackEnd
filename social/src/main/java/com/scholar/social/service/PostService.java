package com.scholar.social.service;

import com.scholar.social.repository.PostRepository;
import com.scholar.social.repository.ReportRepository;
import com.scholar.social.util.Post;
import com.scholar.social.util.SortType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private ReportRepository reportRepository;

    private PostRepository postRepository;

    public int put(Post post) {
        return postRepository.put(post);
    }

    public boolean report(String userId, int postId, String content) {
        reportRepository.report(3, content, String.valueOf(postId), userId);
        return true;
    }

    public boolean delete(String userId, int postId) {
        postRepository.delete(postId);
        return true;
    }

    public List<Post> search(int sectorId, int start, int num, SortType sort, String keyword) {
        // TODO add body
        return null;
    }

    public Post get(String userId, int postId) {
        // TODO add body
        postRepository.updateTimes(postId);
        return null;
    }
}
