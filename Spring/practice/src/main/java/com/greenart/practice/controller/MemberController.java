package com.greenart.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greenart.practice.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberservice;

    @Autowired
    public MemberController(MemberService memberservice){
        this.memberservice = memberservice;
    }
    
    
}
