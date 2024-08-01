package com.panda.CRUD.CRUD_EX.service;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    public ArticleRepository articleRepository;

    public void postArticle(Article article){
        try{
            if(!article.getTitle().isEmpty() && !article.getMain_text().isEmpty())
            {
                articleRepository.save(article);
            }
            else
            {

            }
        }catch (Exception e){}
    }


}