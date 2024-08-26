package com.example.todo_api.controller;


import com.example.todo_api.entity.Post;
import com.example.todo_api.exception.ResourceNotFoundException;
import com.example.todo_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    @Autowired
    private PostService postService;


    @GetMapping()
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPosts(@PathVariable("id") Long id) {

        Post Post = postService.getPostById(id).orElseThrow(() ->  new ResourceNotFoundException("Post not found"));

        return ResponseEntity.ok(Post);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post PostDetails) {
        Post updatePost = postService.updatePost(id, PostDetails);
        return ResponseEntity.ok(updatePost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

}