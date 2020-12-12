package com.scholar.social.service;

import com.scholar.social.util.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    public int put(Post post) {
        // TODO add args and body
        return -1;
    }

    public boolean report(int userId, int postId, String content) {
        // TODO add body
        return false;
    }

    public boolean delete(int userId, int postId) {
        // TODO add body
        return false;
    }

    public List<Post> search(int sectorId, int start, int num, int sort, int keyword) {
        // TODO add body
        return null;
    }

    public Post get(int userId, int postId) {
        // TODO add body
        return null;
    }
}
