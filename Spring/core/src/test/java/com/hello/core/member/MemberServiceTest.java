package com.hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;

public class MemberServiceTest {

    MemberService mService = new MemberServiceImpl();
    @Test
    void join(){
        Member member = new Member(1L, "MemberA", Grade.VIP);
        mService.join(member);
        Member findMember = mService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
