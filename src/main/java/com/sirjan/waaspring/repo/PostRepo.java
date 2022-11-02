package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.dto.PostDto;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post findById(int id);

    void deleteById(int id);

    void update(int id, Post post);
}
