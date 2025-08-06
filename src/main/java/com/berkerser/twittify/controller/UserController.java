package com.berkerser.twittify.controller;

import com.berkerser.twittify.model.User;
import com.berkerser.twittify.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users") //URL prefix belirleme
public class UserController {
    private final UserService userService;

    //Constructor injection ile userService'i enjekte ettim (Solid prensip)
    public UserController(UserService userService){
        this.userService = userService;
    }

    //CREATE
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //READ ALL
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //READ ONE
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserbyId(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}
