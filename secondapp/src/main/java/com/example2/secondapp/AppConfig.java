package com.example2.secondapp;

import com.example2.secondapp.discount.DiscountPolicy;
import com.example2.secondapp.discount.RateDiscountPolicy;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;
import com.example2.secondapp.member.MemoryMemberRepository;
import com.example2.secondapp.order.OrderService;
import com.example2.secondapp.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 AppConfig is only charge of
 1. creating objects that are needed for building app
 2. connecting between classes via constructor -> Dependency Injection
 */
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy getDiscountPolicy(){
        //Switch policy
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
