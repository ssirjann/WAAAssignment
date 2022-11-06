package com.sirjan.waaspring.domain;

import lombok.Data;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    private LocalDateTime dateTime;
    private String principle;
    private String operation;
    private String exceptionType;
    private String message;
}
