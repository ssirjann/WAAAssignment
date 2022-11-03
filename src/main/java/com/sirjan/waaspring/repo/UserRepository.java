package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
