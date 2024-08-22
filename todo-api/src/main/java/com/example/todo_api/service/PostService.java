package com.example.todo_api.service;


import com.example.todo_api.entity.Post;
import com.example.todo_api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return repository.findById(id);
    }

    public Post createPost(Post Post) {
        return repository.save(Post);
    }

    public Post updatePost(Long id, Post PostDetails) {
        Post Post = repository.findById(id).orElseThrow(() -> new RuntimeException("404"));
        Post.setTitle(PostDetails.getTitle());
        Post.setCompleted(PostDetails.getCompleted());
        return repository.save(Post);
    }

    public void deletePost(Long id) {
        Post Post = repository.findById(id).orElseThrow(() -> new RuntimeException("404"));
        repository.delete(Post);
    }
}
