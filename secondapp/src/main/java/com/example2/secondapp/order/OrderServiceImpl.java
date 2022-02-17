package com.example2.secondapp.order;

import com.example2.secondapp.discount.DiscountPolicy;
import com.example2.secondapp.discount.FixDiscountPolicy;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberRepository;
import com.example2.secondapp.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //discountprice is decided by only discountPolicy class -> SRP
        //orderServiceImpl does not care about discount rate according to member's grade at all.
        //Single Responsibility Principal

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
