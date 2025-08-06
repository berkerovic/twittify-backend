package com.berkerser.twittify.service;


import com.berkerser.twittify.model.Post;
import com.berkerser.twittify.model.User;
import com.berkerser.twittify.repository.PostRepository;
import com.berkerser.twittify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //CREATE
    public Post createPost(Long userId, Post post){
        User user = userRepository.findById(userId).orElseThrow();
        post.setUser(user);

        return postRepository.save(post);
    }

    //READ
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }


    //READ ONE
    public Post getPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }
    
    //READ BY USER
    public List<Post> getPostsByUser(Long userId){
        return postRepository.findByUserId(userId);
    }

    //DELETE
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

}
