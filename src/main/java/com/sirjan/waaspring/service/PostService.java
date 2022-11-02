package com.sirjan.waaspring.service;

import com.sirjan.waaspring.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    PostDto findById(int id);

    void delete(int id);

    void update(int id, PostDto postDto);
}
