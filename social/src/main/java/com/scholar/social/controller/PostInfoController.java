package com.scholar.social.controller;

import com.scholar.social.generator.CommentGenerator;
import com.scholar.social.generator.PostGenerator;
import com.scholar.social.generator.UserGenerator;
import com.scholar.social.service.PostService;
import com.scholar.social.service.SectorService;
import com.scholar.social.service.UserService;
import com.scholar.social.util.Comment;
import com.scholar.social.util.Post;
import com.scholar.social.util.SortType;
import com.scholar.social.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.scholar.social.util.ControllerParser.*;
import static com.scholar.social.util.TimeFormat.format;

/**
 * for post search and get post info
 */
@RestController
@CrossOrigin
public class PostInfoController {
    private final PostService postService;
    private final UserService userService;
    private final SectorService sectorService;

    @Autowired
    public PostInfoController(PostService postService,
                              UserService userService,
                              SectorService sectorService) {
        this.postService = postService;
        this.userService = userService;
        this.sectorService = sectorService;
    }

    @RequestMapping(value = "/getPostInfo",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int postId = parsePostId(body);
        Post post = postService.get(userId, postId);
        User user = userService.get(userId);
        Map<String, Object> res = PostGenerator.basicInfo(post);
        res.putAll(UserGenerator.userInfo(user, "creator"));

        // format comments
        List<Map<String, Object>> commentMapList = new ArrayList<>();
        List<Comment> commentList = post.getComments();
        commentList.sort(Comparator.comparingLong(t -> t.getTime().getTime()));
        for (int i = 0; i < commentList.size(); i++) {
            Comment comment = commentList.get(i);
            Map<String, Object> commentMap = CommentGenerator.info(comment);
            commentMap.put("floor", String.valueOf(i + 2));
            commentMap.putAll(UserGenerator
                    .userInfo(userService.get(comment.getUserId()), "commenter"));
            commentMapList.add(commentMap);
        }
        res.put("comments", commentMapList);

        return res;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> search(@RequestBody Map<String, Object> body) {
        int sectorId = parseSectorId(body);
        int start = Integer.parseInt((String) body.get("start"));
        int num = Integer.parseInt((String) body.get("num"));
        SortType sort = SortType.values()[Integer.parseInt((String) body.get("sort"))];
        String keyword = (String) body.get("keyword");

        List<Post> postList = postService.search(sectorId, start, num, sort, keyword);
        List<Map<String, Object>> postMapList = new ArrayList<>();
        // format post
        for (Post post : postList) {
            Map<String, Object> postMap = PostGenerator.basicInfo(post);
            User creator = userService.get(post.getUserId());
            postMap.putAll(UserGenerator.userInfo(creator, "creator"));
            List<Comment> commentList = post.getComments();
            commentList.sort(Comparator.comparingLong(t -> t.getTime().getTime()));
            if (commentList.isEmpty()) {
                postMap.putAll(UserGenerator.userInfo(creator, "editor"));
                postMap.put("editTime", format(post.getCreateTime()));
            } else {
                Comment latest = commentList.get(commentList.size() - 1);
                User editor = userService.get(latest.getUserId());
                postMap.putAll(UserGenerator.userInfo(editor, "editor"));
                postMap.put("editTime", format(latest.getTime()));
            }
            postMapList.add(postMap);
        }

        return Map.of("posts", postMapList);
    }

    @PostMapping(value = "/getUserPosts", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getPostsByUserId(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        List<Post> postList = postService.getPostsByUserId(userId);
        return formatPostList(postList);
    }

    private Map<String, Object> formatPostList(List<Post> postList) {
        Map<Integer, String> sectorNameMap = sectorService.getSectorNameMap();
        List<Map<String, Object>> postMapList = postList.stream()
                .map(post -> {
                    Map<String, Object> postMap = PostGenerator.basicInfo(post);
                    postMap.put("sectorName", sectorNameMap.get(post.getSectorId()));
                    return postMap;
                })
                .collect(Collectors.toList());
        return Map.of("posts", postMapList);
    }

    @PostMapping(value = "/getFollowedPosts", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getPostsByFollowing(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        List<Post> postList = postService.getPostsByFollowing(userId);
        return formatPostList(postList);
    }
}
