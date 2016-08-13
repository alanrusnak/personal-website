package com.alanrusnak.personalwebsite.controllers;

import com.alanrusnak.personalwebsite.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String recentPosts() {
       return "recentPosts";
    }

    @RequestMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts",postRepository.findAll());
        return "allPosts";
    }



}
