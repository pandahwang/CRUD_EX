package com.panda.CRUD.CRUD_EX.Article.controller;

import com.panda.CRUD.CRUD_EX.Article.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "../static/index.html";
    }
}
