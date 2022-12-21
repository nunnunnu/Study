package com.hello.core;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService mService = new MemberServiceImpl();
        Member member = new Member(1L,"MemberA",Grade.VIP);
        mService.join(member);
        System.out.println(mService.findMember(1L));
        System.out.println(member);
        // 순수 자바 코드 구현방법
        
    }
}
