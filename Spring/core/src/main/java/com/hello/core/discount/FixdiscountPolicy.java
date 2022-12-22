package com.hello.core.discount;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;

public class FixdiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int pricar) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 500;
        }
    }

}
