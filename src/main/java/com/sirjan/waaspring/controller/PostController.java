package com.sirjan.waaspring.controller;

import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getPosts(@PathVariable int userId) {

        return postService.findAll(userId);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable int userId, @PathVariable int id) {

        return postService.findById(userId, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int userId, @PathVariable int id) {
        postService.delete(userId, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable int userId, @PathVariable int id, @RequestBody PostDto postDto) {

        postService.update(userId, id, postDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@PathVariable int userId, @RequestBody PostDto postDto) {
        postService.save(userId, postDto);
    }
}
