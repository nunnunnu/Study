package com.hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach(){
        Appconfig a = new Appconfig();
        memberService = a.memberService();
        orderService = a.orderService();
    }

    @Test
    void createOrder(){
        Long id = 1L;
        Member m = new Member(1L, "Memberid1", Grade.VIP);
        memberService.join(m);

        Order o = orderService.createOrder(id, "itemB", 15000);

        Assertions.assertThat(o.getDiscountPrice()).isEqualTo(1000);
    }
}
