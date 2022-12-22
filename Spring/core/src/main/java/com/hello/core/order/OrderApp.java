package com.hello.core.order;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.Member.MemberService;
import com.hello.core.Member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        Appconfig a = new Appconfig();
        MemberService memberService = a.memberService();
        OrderService orderService = a.orderService();
        Long memberid = 1L;
        Member member = new Member(memberid, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberid, "itemA", 10000);

        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
