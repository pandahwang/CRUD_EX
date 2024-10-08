package com.panda.CRUD.CRUD_EX.Article.service;

import com.panda.CRUD.CRUD_EX.Article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ViewService {
    @Autowired
    public ArticleRepository articleRepository;
    public void viewArticle(Long id, Model model){
        var article = articleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("article",article);
    }
}
