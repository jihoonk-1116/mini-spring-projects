package com.example2.secondapp;

import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;
import com.example2.secondapp.order.Order;
import com.example2.secondapp.order.OrderService;
import com.example2.secondapp.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "Test member", Grade.VIP);
        memberService.join(member);

        Order testOrder = orderService.createOrder(1L, "Test item", 10000);

        System.out.println(testOrder);
        System.out.println(testOrder.calculatePrice());
    }
}
