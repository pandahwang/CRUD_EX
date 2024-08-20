package com.panda.CRUD.CRUD_EX.Article.service;

import com.panda.CRUD.CRUD_EX.Article.repository.ArticleRepository;
import com.panda.CRUD.CRUD_EX.Article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    public ArticleRepository articleRepository;

    public void postArticle(Article article) throws IllegalArgumentException {
        if (article.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }

        if (article.getMainText().trim().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }

        if(article.getTitle().length()>100) {
            throw new IllegalArgumentException("제목은 100 글자를 초과할 수 없습니다.");
        }
        if(article.getMainText().length()>10000){
            throw new IllegalArgumentException("내용은 10000 글자를 초과할 수 없습니다.");
        }

        articleRepository.save(article);
    }


}