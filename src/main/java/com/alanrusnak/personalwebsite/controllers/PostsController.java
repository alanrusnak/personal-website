package com.alanrusnak.personalwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {

    @RequestMapping("/")
    public String recentPosts() {
       return "recentPosts";
    }

    @RequestMapping("/posts")
    public String allPosts() {
        return "allPosts";
    }



}
