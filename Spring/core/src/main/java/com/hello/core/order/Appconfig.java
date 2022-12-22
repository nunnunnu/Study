package com.hello.core.order;

import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;
import com.hello.core.Member.MemoryMemberRepository;
import com.hello.core.discount.FixdiscountPolicy;

public class Appconfig {
    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixdiscountPolicy());
    }
}
