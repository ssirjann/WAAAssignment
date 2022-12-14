package com.sirjan.waaspring.controller;

import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable int id) {
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
    }
}
