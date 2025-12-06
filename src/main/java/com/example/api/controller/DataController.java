package com.example.api.controller;

import com.example.api.model.Post;
import com.example.api.model.User;
import com.example.api.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final DataService service;

    public DataController(DataService service) {
        this.service = service;
    }

    @GetMapping("/refresh")
    public String refreshCache() {
        service.refreshCache();
        return "Cache updated successfully";
    }

    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(required = false) Integer userId) {
        if (userId != null) {
            return service.getPostsByUser(userId);
        }
        return service.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostDetails(@PathVariable int id) {
        return service.getPostById(id);
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserDetails(@PathVariable int id) {
        return service.getUserById(id);
    }

}
