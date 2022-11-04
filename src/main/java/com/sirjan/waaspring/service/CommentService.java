package com.sirjan.waaspring.service;

import com.sirjan.waaspring.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll(int postId);

    CommentDto findById(int postId, int id);

    void save(int postId, CommentDto commentDto);

    void delete(int postId, int id);

    void update(int postId, int id, CommentDto commentDto);
}
