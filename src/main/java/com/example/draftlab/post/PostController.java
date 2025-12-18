package com.example.draftlab.post;

import com.example.draftlab.post.dto.CreatePostRequest;
import com.example.draftlab.post.dto.CreatePostResponse;
import com.example.draftlab.post.dto.ReadPostsResponse;
import com.example.draftlab.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @PostMapping("/posts")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest request) {
        Post createdPost = postService.createPost(request);
        CreatePostResponse response = new CreatePostResponse(
            createdPost.getIdx(),
            createdPost.getUserIdx(),
            createdPost.getTitle(),
            createdPost.getCategory(),
            createdPost.getTag(),
            createdPost.getContents(),
            createdPost.getCreatedAt(),
            createdPost.getUpdatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/posts")
    public ResponseEntity<ReadPostsResponse> readPosts() {
        List<Post> posts = postService.getAllPosts();
        List<ReadPostsResponse.PostInfo> postInfos = posts.stream()
            .map(post -> new ReadPostsResponse.PostInfo(
                post.getIdx(),
                post.getUserIdx(),
                post.getTitle(),
                post.getCategory(),
                post.getTag(),
                post.getContents(),
                post.getCreatedAt(),
                post.getUpdatedAt()
            ))
            .collect(Collectors.toList());
        
        ReadPostsResponse response = new ReadPostsResponse(postInfos);
        return ResponseEntity.ok(response);
    }
}