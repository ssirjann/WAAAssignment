package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByPostId(int postId);
}
