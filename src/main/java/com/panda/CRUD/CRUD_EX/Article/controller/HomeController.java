package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import com.panda.CRUD.CRUD_EX.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "../static/index.html";
    }
}
