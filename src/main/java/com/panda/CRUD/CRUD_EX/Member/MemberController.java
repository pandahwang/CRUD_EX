package com.panda.CRUD.CRUD_EX.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "/Member/login.html";
    }

    @GetMapping("/registerForm")
    public String register(){
        return "/Member/register.html";
    }

    @PostMapping("/registerConfirm")
    public String register(Member member) {
        memberService.register(member);
        return "redirect:/login";
    }
}
