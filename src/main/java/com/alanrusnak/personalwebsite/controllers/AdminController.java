package com.alanrusnak.personalwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String recentPosts() {
        return "admin/index";
    }
}
