package com.sirjan.waaspring.controller;

import com.sirjan.waaspring.aspect.annotation.ExecutionTime;
import com.sirjan.waaspring.domain.dto.UserDto;
import com.sirjan.waaspring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public UserDto getUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/filter/posts/{count}")
    public List<UserDto> findByPostCount(@PathVariable int count) {
        return userService.findByPostsGreaterThan(count);
    }

    @GetMapping("/filter/posts/title/{title}")
    public List<UserDto> findByPostTitle(@PathVariable String title) {
        return userService.findByPostsStartsWith(title);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

}
