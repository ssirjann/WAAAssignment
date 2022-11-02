package com.sirjan.waaspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
}
