package com.greenart.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greenart.practice.domain.MemberRepository;
import com.greenart.practice.service.MemberService;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired //생성자가 하나라서 생략가능
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
