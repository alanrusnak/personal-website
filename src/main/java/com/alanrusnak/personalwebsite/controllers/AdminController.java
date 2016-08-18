package com.alanrusnak.personalwebsite.controllers;

import com.alanrusnak.personalwebsite.models.Post;
import com.alanrusnak.personalwebsite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private PostService postService;

    @RequestMapping(value={"/admin", "/admin/edit-posts"})
    public String editPosts() {
        return "admin/edit-posts";
    }

    @RequestMapping(value="/admin/new-post", method= RequestMethod.GET)
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "admin/new-post";
    }

    @RequestMapping(value="/admin/new-post", method= RequestMethod.POST)
    public String newPostSubmit(@ModelAttribute Post post) {
        postService.savePost(post);
        return "/admin/edit-posts";
    }
}
