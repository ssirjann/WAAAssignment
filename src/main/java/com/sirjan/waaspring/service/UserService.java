package com.sirjan.waaspring.service;

import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(int id);

    void delete(int id);

    void update(int id, UserDto userDto);

    void save(UserDto userDto);

    List<PostDto> findPostsById(int id);
}
