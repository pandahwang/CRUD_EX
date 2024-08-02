package com.panda.CRUD.CRUD_EX.controller;

import com.panda.CRUD.CRUD_EX.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {
    @Autowired
    public DeleteService deleteService;

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        deleteService.deleteArticle(id);
        return "redirect:/list";
    }
}
