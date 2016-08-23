package com.alanrusnak.personalwebsite.controllers;

import com.alanrusnak.personalwebsite.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String recentPosts(Model model) {
        model.addAttribute("posts",postRepository.findTop5ByOrderByIdDesc());
       return "recent-posts";
    }

    @RequestMapping("/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts",postRepository.findAllByOrderByIdDesc());
        return "all-posts";
    }

    @RequestMapping("/post/{postId}")
    public String getPost(@PathVariable(value="postId") String postId, Model model) {
        model.addAttribute("post", postRepository.findOne(Long.parseLong(postId)));
        return "post";
    }



}
