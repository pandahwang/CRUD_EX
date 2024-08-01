package com.panda.CRUD.CRUD_EX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WriteController {
    @GetMapping("/write")
    public String write(){
        return "write.html";
    }
}
