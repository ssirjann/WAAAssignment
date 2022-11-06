package com.sirjan.waaspring.repo;

import com.sirjan.waaspring.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer> {
}
