package com.berkerser.twittify.controller;

import com.berkerser.twittify.model.Post;
import com.berkerser.twittify.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    //CREATE
    @PostMapping("/user/{userId}")
    public Post createPost(@PathVariable Long userId, @RequestBody Post post){
        return postService.createPost(userId, post);
    }
    
    //READ
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Long userId){
        return postService.getPostsByUser(userId);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
