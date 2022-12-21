package com.hello.core.order;

import com.hello.core.Member.MemberRepository;
import com.hello.core.Member.MemoryMemberRepository;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixdiscountPolicy;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy dicountPolicy = new FixdiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        
        return null;
    }
    
}
