package com.hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hello.core.Member.Grade;
import com.hello.core.Member.Member;
import com.hello.core.discount.RateDiscountPolicy;

public class ReateDiscountPolicyTest {
    
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member m = new Member(1L, "MemberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(m, 15000);
        
        //then
        Assertions.assertThat(discount).isEqualTo(1500);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    void vip_x(){
        //given
        Member m = new Member(2L, "MemberBASIC", Grade.BASIC);
    
        //when
        int discount = discountPolicy.discount(m, 15000);
        
        //then
        Assertions.assertThat(discount).isEqualTo(0);
        
    }
}
