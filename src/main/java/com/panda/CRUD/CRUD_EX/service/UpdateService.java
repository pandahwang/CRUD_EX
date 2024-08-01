package com.panda.CRUD.CRUD_EX.service;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    @Autowired
    public ArticleRepository articleRepository;

    public void updateArticle(Long id, Article article){
        article.setId(id);
        articleRepository.save(article);
    }
}