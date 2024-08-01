package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @Autowired
    public ViewService viewService;

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        viewService.viewArticle(id, model);
        return "view-page";
    }

}
