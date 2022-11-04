package com.sirjan.waaspring.service;

import com.sirjan.waaspring.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll(int userId);
    PostDto findById(int id, int i);

    void delete(int id, int i);

    void update(int id, int i, PostDto postDto);

    void save(int userId, PostDto postDto);
}
