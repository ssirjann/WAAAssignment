package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.repo.PostRepo;
import com.sirjan.waaspring.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PostDto> findAll() {
        return postRepo
                .findAll()
                .stream()
                .map(x -> mapper.map(x, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        return mapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(int id, PostDto postDto) {
        postRepo.update(id, mapper.map(postDto, Post.class));
    }
}
