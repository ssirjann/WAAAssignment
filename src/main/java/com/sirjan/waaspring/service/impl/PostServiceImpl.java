package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.repo.PostRepository;
import com.sirjan.waaspring.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private ModelMapper mapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, ModelMapper mapper) {
        this.postRepo = postRepo;
        this.mapper = mapper;
    }

    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream().map(x -> mapper.map(x, PostDto.class)).collect(Collectors.toList());
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
        postDto.setId(id);
        postRepo.save(mapper.map(postDto, Post.class));
    }
}
