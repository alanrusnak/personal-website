package com.alanrusnak.personalwebsite.repositories;

import com.alanrusnak.personalwebsite.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByOrderByIdDesc();
    List<Post> findTop5ByOrderByIdDesc();

}
