package com.sirjan.waaspring.repo;

import org.springframework.data.repository.CrudRepository;
import com.sirjan.waaspring.domain.Exception;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends CrudRepository<Exception, Integer> {

}
