package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.model.Article;
import com.panda.CRUD.CRUD_EX.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UpdateController {
    @Autowired
    public UpdateService updateService;

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Article article, Model model) {
        try
        {
            updateService.updateArticle(id, article);
            return "redirect:/list";
        }
        catch (IllegalArgumentException e)
        {
            model.addAttribute("error",e.getMessage());
            return "edit-page.html";
        }
    }
}
