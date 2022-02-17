package com.example2.secondapp.discount;

import com.example2.secondapp.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @return the discounted price
     */
    int discount(Member member, int price);
}
