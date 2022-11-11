package com.sirjan.waaspring.controller;

import com.sirjan.waaspring.domain.Comment;
import com.sirjan.waaspring.domain.Exception;
import com.sirjan.waaspring.domain.Logger;
import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.User;
import com.sirjan.waaspring.repo.CommentRepository;
import com.sirjan.waaspring.repo.ExceptionRepository;
import com.sirjan.waaspring.repo.PostRepository;
import com.sirjan.waaspring.repo.UserRepository;
import com.sirjan.waaspring.service.ExceptionService;
import com.sirjan.waaspring.service.LoggerService;
import com.sirjan.waaspring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    public PostRepository postRepo;
    @Autowired
    public CommentRepository commentRepo;
    @Autowired
    public ModelMapper mapper;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public ExceptionRepository exceptionRepository;

    @Autowired
    public ExceptionService exceptionService;


    @Autowired
    UserService service;

    @Autowired
    LoggerService loggerService;

    @GetMapping
    public void test() {
//        service.findById(1);

        service.findById(2);
    }

    @DeleteMapping
    public void delete() {
        exceptionService.save(null);
//        throw new RuntimeException("Look at this beautiful exception message");
//        Exception ex = new Exception();
//        ex.setOperation("SET");
//        ex.setPrinciple("Sirjan");
//        ex.setExceptionType("Type");
//        ex.setDateTime(LocalDateTime.now());
//
//        exceptionService.save(ex);
    }
}
