package com.jpabook.jpashop;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jpabook.jpashop.domain.Member;


@SpringBootTest
public class MemberRepositoryTest {

    @Test
    @Rollback(false) //rollback안하고 commit해버림
    @Transactional
    public void test() throws Exception{
        Member member = new Member();
    }
}
