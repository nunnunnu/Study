package com.greenart.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.greenart.practice.domain.Member;
import com.greenart.practice.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberservice;

    @Autowired//Spring 컨테이너의 memberservice와 연결시켜줌.
    public MemberController(MemberService memberservice){
        this.memberservice = memberservice;
    }
    
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberservice.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
