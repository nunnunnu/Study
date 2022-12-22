package com.hello.core.discount;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()==Grade.VIP){
            return (int)(price*0.1);
        }
        return 0;
    }
    
}
