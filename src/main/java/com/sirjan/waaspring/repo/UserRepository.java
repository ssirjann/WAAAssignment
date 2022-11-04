package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u where u.posts.size > :count")
    List<User> findByPostsGreaterThan(int count);

    List<User> findByPostsTitleStartsWithIgnoreCase(String title);
}
