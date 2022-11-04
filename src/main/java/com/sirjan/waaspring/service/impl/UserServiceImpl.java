package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.User;
import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.domain.dto.UserDto;
import com.sirjan.waaspring.repo.UserRepository;
import com.sirjan.waaspring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(x -> mapper.map(x, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int id) {
        return mapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userDto.setId(id);
        userRepo.save(mapper.map(userDto, User.class));
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(mapper.map(userDto, User.class));
    }

    @Override
    public List<PostDto> findPostsById(int id) {
        return userRepo
                .findById(id)
                .get()
                .getPosts()
                .stream()
                .map(x -> mapper.map(x, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findByPostsGreaterThan(int count) {
        return userRepo
                .findByPostsGreaterThan(count)
                .stream()
                .map(x -> mapper.map(x, UserDto.class))
                .collect(Collectors.toList());
    }
}
