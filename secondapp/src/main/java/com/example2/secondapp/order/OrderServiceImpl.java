package com.example2.secondapp.order;

import com.example2.secondapp.discount.DiscountPolicy;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    /*
        private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
        OCP , DIP should not be employed.
        it doesn't close to change of code. And, OrderService depends on both of DiscountPolicy and its object
        The object has to be injected by Spring using config class
    */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        //Now, Both of DIP, OCP are followed. OrderServiceiImpl only depends on interfaces.
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


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
