package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView() {
        // it has to be the exact name we have on templates, but without .html
        return "login";
    }

    @GetMapping("courses")
    public String getCourses() {
        // it has to be the exact name we have on templates, but without .html
        return "courses";
    }
}
