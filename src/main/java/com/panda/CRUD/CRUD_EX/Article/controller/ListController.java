package com.panda.CRUD.CRUD_EX.Article.controller;

import com.panda.CRUD.CRUD_EX.Article.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @Autowired
    public ListService listService;

    @GetMapping("/list")
    public String list(Model model){
        listService.getList(model);
        return "list.html";
    }
}
