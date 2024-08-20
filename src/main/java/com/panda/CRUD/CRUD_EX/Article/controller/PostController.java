package com.panda.CRUD.CRUD_EX.Article.controller;

import com.panda.CRUD.CRUD_EX.Article.model.Article;
import com.panda.CRUD.CRUD_EX.Article.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    public PostService postService;

    @PostMapping("/post")
    public String post(Article article, Model model){
        try
        {
            postService.postArticle(article);
            return "redirect:/list";
        }
        catch (IllegalArgumentException e)
        {
            model.addAttribute("error",e.getMessage());
            return "write.html";
        }
    }
}
