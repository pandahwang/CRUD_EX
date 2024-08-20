package com.panda.CRUD.CRUD_EX.Article.controller;

import com.panda.CRUD.CRUD_EX.Article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditController {
    @Autowired
    public ArticleRepository articleRepository;

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        var article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("article", article);
        return "edit-page.html";
    }
}
