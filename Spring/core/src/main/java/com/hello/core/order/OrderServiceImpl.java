package com.hello.core.order;

import com.hello.core.Member.Member;
import com.hello.core.Member.MemberRepository;
import com.hello.core.Member.MemoryMemberRepository;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixdiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService {
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixdiscountPolicy();
    //만약 할인 정책이 변경된다면 new FixdiscountPolicy()만 고쳐주면 전체 변경 가능
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //그러나 이 방식은 RateDicountPolicy에도 의존중인 상태로 DIP위반
    //코드를 바꿔줘야한다는 자체가 OCP 위반임.
    //인터페이스에만 의존하도록 의존관계를 변경해야함.
    
    private DiscountPolicy discountPolicy; //인터페이스에만 의존중임. 그러나 이대로면 NullPointerException 발생
    private final MemberRepository memberRepository;
    //OrderServiceImlp에 구현객체를 대신 생성해주어야함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
