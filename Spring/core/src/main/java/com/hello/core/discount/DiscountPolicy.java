package com.hello.core.discount;

import com.hello.core.Member.Member;

public interface DiscountPolicy {
    //@return 할인 대상 금액
    int discount(Member meber, int pricar);
}
