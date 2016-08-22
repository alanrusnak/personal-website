package com.alanrusnak.personalwebsite.service;

import com.alanrusnak.personalwebsite.models.Post;
import com.alanrusnak.personalwebsite.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    public void savePost(Post post){
        if(post.getCreationTime() == null){
            post.setCreationTime(LocalDateTime.now());
        }
        postRepository.save(post);
        log.info("Saved new post: {}", post);
    }

}
