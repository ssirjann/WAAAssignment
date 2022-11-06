package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.Logger;
import com.sirjan.waaspring.repo.LoggerRepository;
import com.sirjan.waaspring.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerRepository loggerRepo;

    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
