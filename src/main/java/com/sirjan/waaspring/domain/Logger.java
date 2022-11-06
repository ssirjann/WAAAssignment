package com.sirjan.waaspring.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    private LocalDateTime dateTime;
//    private String time;
    private String principle;
    private String operation;
}
