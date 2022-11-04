package com.sirjan.waaspring.controller;

import com.sirjan.waaspring.domain.dto.CommentDto;
import com.sirjan.waaspring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getAll(@PathVariable int postId) {
        return commentService.findAll(postId);
    }

    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable int postId, @PathVariable int id) {
        return commentService.findById(postId, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@PathVariable int postId, @RequestBody CommentDto commentDto) {
        commentService.save(postId, commentDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@PathVariable int postId, @PathVariable int id) {
        commentService.delete(postId, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable int postId, @PathVariable int id, @RequestBody CommentDto commentDto) {
        commentService.update(postId, id, commentDto);
    }

}
