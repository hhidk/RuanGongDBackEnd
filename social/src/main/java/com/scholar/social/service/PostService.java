package com.scholar.social.service;

import com.scholar.social.util.Post;
import com.scholar.social.util.SortType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    public int put(Post post) {
        // TODO add args and body
        return -1;
    }

    public boolean report(String userId, int postId, String content) {
        // TODO add body
        return false;
    }

    public boolean delete(String userId, int postId) {
        // TODO add body
        return false;
    }

    public List<Post> search(int sectorId, int start, int num, SortType sort, String keyword) {
        // TODO add body
        return null;
    }

    public Post get(String userId, int postId) {
        // TODO add body
        // TODO add view times
        return null;
    }
}
