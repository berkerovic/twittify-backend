package com.berkerser.twittify.service;

import com.berkerser.twittify.model.User;
import com.berkerser.twittify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    //CREATE
    public User createUser(User user){
        return userRepository.save(user);
    }

    //READ
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserbyId(Long id){
        return userRepository.findById(id).orElse(null);
    }

    //UPDATE
    public User updateUser(Long id, User userDetails){
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    //DELETE
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
