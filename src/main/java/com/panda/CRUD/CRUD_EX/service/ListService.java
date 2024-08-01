package com.panda.CRUD.CRUD_EX.service;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ListService {

    @Autowired
    public ArticleRepository articleRepository;

    public void getList(Model model){
        List<Article> articles = articleRepository.findAll();
        articles.forEach(article -> {
            String truncatedText = truncate(article.getMain_text());
            article.setMain_text(truncatedText);
        });
        model.addAttribute("Articles", articles);
    }

    // 본문 내용을 10글자로 자르고 + ...
    public String truncate(String text) {
        if (text == null || text.length() <= 10) {
            return text;
        }
        return text.substring(0, 10) + "...";
    }

}
