package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.repository.ArticleRepository;
import com.panda.CRUD.CRUD_EX.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    public ArticleRepository articleRepository;
    @Autowired
    public ListService listService;
    @Autowired
    public PostService postService;
    @Autowired
    public UpdateService updateService;
    @Autowired
    public DeleteService deleteService;
    @Autowired
    public ViewService viewService;

    @GetMapping("/")
    public String home(){
        return "../static/index.html";
    }

    @GetMapping("/list")
    public String list(Model model){
        listService.getList(model);
        return "list.html";
    }

    @GetMapping("/write")
    public String write(){
        return "write.html";
    }

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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        var article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("article", article);
        return "edit-page";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Article article) {
        updateService.updateArticle(id, article);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        deleteService.deleteArticle(id);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        viewService.viewArticle(id, model);
        return "view-page";
    }

}
