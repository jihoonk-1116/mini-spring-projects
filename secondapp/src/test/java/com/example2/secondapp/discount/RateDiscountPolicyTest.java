package com.example2.secondapp.discount;

import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP should be offered 10% discount")
    void discount() {
        Member member = new Member(1L, "VIP member", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        //option + enter for on demand static import
        Assertions.assertThat(discount).isEqualTo(1000);

    }
}