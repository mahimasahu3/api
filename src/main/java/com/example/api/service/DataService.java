package com.example.api.service;

import com.example.api.exception.ApiException;
import com.example.api.model.Post;
import com.example.api.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DataService {

    private final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    private List<Post> postCache = new ArrayList<>();
    private List<User> userCache = new ArrayList<>();

    private final RestTemplate restTemplate = new RestTemplate();

    // Fetch and Cache
    public void refreshCache() {
        try {
            Post[] posts = restTemplate.getForObject(POSTS_URL, Post[].class);
            User[] users = restTemplate.getForObject(USERS_URL, User[].class);

            if (posts == null || users == null) {
                throw new ApiException("Invalid API response (null data)");
            }

            postCache = Arrays.asList(posts);
            userCache = Arrays.asList(users);

        } catch (RestClientException e) {
            throw new ApiException("Failed to fetch API data: " + e.getMessage());
        }
    }

    public List<Post> getAllPosts() {
        return postCache;
    }

    public List<Post> getPostsByUser(int userId) {
        return postCache.stream()
                .filter(p -> p.getUserId() == userId)
                .toList();
    }

    public Post getPostById(int id) {
        return postCache.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ApiException("Post not found with ID: " + id));
    }
    
    public List<User> getAllUsers() {
        return userCache;
    }

    public User getUserById(int id) {
        return userCache.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ApiException("User not found with ID: " + id));
    }

}

