package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        List<Article> articles = articleRepository.findAll();
        articles.forEach(article -> {
            String truncatedText = truncate(article.getMain_text());
            article.setMain_text(truncatedText);
        });
        model.addAttribute("Articles",articleRepository.findAll());
        return "list.html";
    }
    // 본문 내용을 10글자로 자르고 + ...
    private String truncate(String text) {
        if (text == null || text.length() <= 10) {
            return text;
        }
        return text.substring(0, 10) + "...";
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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        var article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("article", article);
        return "edit-page";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Article article) {
        article.setId(id);
        articleRepository.save(article);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        var article = articleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("article", article);
        return "view-page";
    }

}
