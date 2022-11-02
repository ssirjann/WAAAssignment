package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
