package com.jpabook.jpashop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import com.jpabook.jpashop.service.MemberService;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Test
    @Rollback(false) //rollback안하고 commit해버림
    @Transactional
    public void test() throws Exception{
        Member member = new Member();
    }

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    // @Rollback(false)
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("kim");

        Long saveId =memberService.join(member);
        em.flush(); //rollback설정을 유지하면서 insert 쿼리문을 보기위해 확인
        assertEquals(member, memberRepository.findOne(saveId));

    }
    @Test
    public void 중복회원예외() throws Exception{
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        try{
            memberService.join(member2);
        }catch(IllegalStateException e){
            return;
        }

        fail("예외가 발생해야한다"); //위에서 예외가 발생하지않으면 실패처리됨
    }
}
