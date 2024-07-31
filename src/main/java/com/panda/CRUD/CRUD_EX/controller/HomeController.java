package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArticleRepository articleRepository;

    @GetMapping("/")
    public String home(){
        return "../static/index.html";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("Articles",articleRepository.findAll());
        return "list.html";
    }

    @GetMapping("/write")
    public String asdf(){
        return "write.html";
    }

    @PostMapping("/post")
    public String post(Article article){
        articleRepository.save(article);
        return "redirect:/list";
    }

}
