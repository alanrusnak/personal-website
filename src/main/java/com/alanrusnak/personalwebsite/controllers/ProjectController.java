package com.alanrusnak.personalwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @RequestMapping("/projects")
    public String getProjects() {
        return "projects";
    }
}
