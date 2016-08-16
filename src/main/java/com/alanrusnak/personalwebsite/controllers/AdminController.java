package com.alanrusnak.personalwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping(value={"/admin", "/admin/edit-posts"})
    public String editPosts() {
        return "admin/edit-posts";
    }

    @RequestMapping("/admin/new-post")
    public String newPost() {
        return "admin/new-post";
    }
}
