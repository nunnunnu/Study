package com.hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;
import com.hello.core.order.Appconfig;

public class MemberServiceTest {
    MemberService mService;
    
    @BeforeEach //각 테스트 실행 전 무조건 실행되는 테스트
    public void BeforeEach(){
        Appconfig a = new Appconfig();
        mService = a.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L, "MemberA", Grade.VIP);
        mService.join(member);
        Member findMember = mService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
