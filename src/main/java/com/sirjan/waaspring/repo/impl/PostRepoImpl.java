package com.sirjan.waaspring.repo.impl;

import com.sirjan.waaspring.domain.Post;
import com.sirjan.waaspring.domain.dto.PostDto;
import com.sirjan.waaspring.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private List<Post> posts;
    private static int seed = 10;

    @Autowired
    private ModelMapper mapper;

    public PostRepoImpl() {
        posts = new ArrayList<>();

        posts.add(new Post(1, "First Post", "The is the first ever post in the system.", "Sirjan Sharma"));
        posts.add(new Post(2, "Another One", "DJ khaled of post. Another One.", "Khaled"));
        posts.add(new Post(3, "Harry Popper", "Pop is where harry be.", "JK Rowing"));
        posts.add(new Post(4, "Lizards of louisiana", "Ye're a lizard, larry", "Selgo"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteById(int id) {
        posts = posts.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void update(int id, Post post) {
        post.setId(id);

        posts.stream().filter(x -> x.getId() == id).forEach(x -> mapper.map(post, x));
    }
}
