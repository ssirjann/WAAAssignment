package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Comment;
import com.sirjan.waaspring.domain.dto.CommentDto;
import com.sirjan.waaspring.repo.CommentRepository;
import com.sirjan.waaspring.repo.PostRepository;
import com.sirjan.waaspring.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CommentDto> findAll(int postId) {
        return commentRepo
                .findByPostId(postId)
                .stream()
                .map(x -> mapper.map(x, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(int postId, int id) {
        Comment comment = getComment(postId, id);

        return mapper.map(comment, CommentDto.class);
    }

    @Override
    public void save(int postId, CommentDto commentDto) {
        Comment comment = mapper.map(commentDto, Comment.class);
        comment.setPost(postRepo.findById(postId).get());
        commentRepo.save(comment);
    }

    @Override
    public void delete(int postId, int id) {
        Comment comment = getComment(postId, id);

        commentRepo.delete(comment);
    }

    private Comment getComment(int postId, int id) {
        Comment comment = commentRepo.findById(id).orElse(null);

        if (comment == null || comment.getPost().getId() != postId)
            throw new RuntimeException("Could not find comment");
        return comment;
    }

    @Override
    public void update(int postId, int id, CommentDto commentDto) {
        commentDto.setId(id);
        Comment comment = getComment(postId, id);
        mapper.map(commentDto, comment);
        commentRepo.save(comment);
    }
}
