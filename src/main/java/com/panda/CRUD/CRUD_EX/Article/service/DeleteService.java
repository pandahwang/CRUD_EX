package com.panda.CRUD.CRUD_EX.Article.service;

import com.panda.CRUD.CRUD_EX.Article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
    @Autowired
    public ArticleRepository articleRepository;

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }
}
