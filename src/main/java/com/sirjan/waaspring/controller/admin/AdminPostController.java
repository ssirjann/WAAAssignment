package com.sirjan.waaspring.controller.admin;

import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/posts")
public class AdminPostController {

    private final PostService postService;

    public AdminPostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getPosts() {

        return postService.findAll();
    }
}
