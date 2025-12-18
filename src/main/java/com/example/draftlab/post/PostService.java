package com.example.draftlab.post;

import com.example.draftlab.post.dto.CreatePostRequest;
import com.example.draftlab.post.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public Post createPost(CreatePostRequest request) {
        Post post = new Post();
        post.setUserIdx(request.getUserIdx());
        post.setTitle(request.getTitle());
        post.setCategory(request.getCategory());
        post.setTag(request.getTag());
        post.setContents(request.getContents());
        // createdAt과 updatedAt은 @PrePersist에서 자동 설정됨
        
        return postRepository.save(post);
    }
    
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}