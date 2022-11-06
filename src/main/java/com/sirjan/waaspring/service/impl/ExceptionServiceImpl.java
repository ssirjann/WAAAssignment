package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.repo.ExceptionRepository;
import com.sirjan.waaspring.service.ExceptionService;
import com.sirjan.waaspring.domain.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    private ExceptionRepository exceptionRepository;

    @Autowired
    public ExceptionServiceImpl(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @Override
    public void save(Exception exception) {
        exceptionRepository.save(exception);
    }
}
