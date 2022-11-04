package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.repo.PostRepository;
import com.sirjan.waaspring.repo.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, ModelMapper mapper, UserRepository userRepository) {
        this.postRepo = postRepo;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDto> findAll(int userId) {
        return postRepo.findByUserId(userId).stream().map(x -> mapper.map(x, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int userId, int id) {
        return mapper.map(getPost(userId, id), PostDto.class);
    }

    private Post getPost(int userId, int id) {
        Post post = postRepo.findById(id).orElse(null);

        if (post == null || post.getUser().getId() != userId)
            throw new RuntimeException("Could not find post");

        return post;
    }

    @Override
    public void delete(int userId, int id) {

        postRepo.delete(getPost(userId, id));
    }

    @Override
    public void update(int userId, int id, PostDto postDto) {
        Post post = getPost(userId, id);
        postDto.setId(id);
        mapper.map(postDto, post);

        postRepo.save(post);
    }

    @Override
    public void save(int userId, PostDto postDto) {
        Post post = mapper.map(postDto, Post.class);
        post.setUser(userRepository.findById(userId).get());
        postRepo.save(post);
    }
}
