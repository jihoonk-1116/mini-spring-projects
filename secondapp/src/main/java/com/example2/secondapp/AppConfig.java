package com.example2.secondapp;

import com.example2.secondapp.discount.DiscountPolicy;
import com.example2.secondapp.discount.FixDiscountPolicy;
import com.example2.secondapp.discount.RateDiscountPolicy;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;
import com.example2.secondapp.member.MemoryMemberRepository;
import com.example2.secondapp.order.OrderService;
import com.example2.secondapp.order.OrderServiceImpl;

/*
 AppConfig is only charge of
 1. creating objects that are needed for building app
 2. connecting between classes via constructor -> Dependency Injection
 */
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy getDiscountPolicy(){
        //Switch policy
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
