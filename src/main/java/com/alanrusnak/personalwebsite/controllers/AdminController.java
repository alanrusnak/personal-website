package com.alanrusnak.personalwebsite.controllers;

import com.alanrusnak.personalwebsite.models.Post;
import com.alanrusnak.personalwebsite.repositories.PostRepository;
import com.alanrusnak.personalwebsite.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController .class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @RequestMapping(value={"/admin", "/admin/edit-posts"})
    public String editPosts(Model model) {
        model.addAttribute("posts",postRepository.findAllByOrderByIdDesc());
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
        return "redirect:/admin/edit-posts";
    }

    @RequestMapping("/admin/edit-post/{postId}")
    public String editPost(@PathVariable(value="postId") String postId, Model model) {
        model.addAttribute("post", postRepository.findOne(Long.parseLong(postId)));
        log.info("Edit page: {}", postId);
        return "admin/edit-post";
    }

    @RequestMapping(value="/admin/edit-post", method= RequestMethod.POST)
    public String editPostSubmit(@ModelAttribute Post post) {
        log.info("Saving post: {}", post);
        postService.savePost(post);
        log.info("Saved post: {}", post);
        return "redirect:/admin/edit-posts";
    }
}
