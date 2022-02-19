package com.example2.secondapp;

import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        //Spring is registering beans in the AppConfig class
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member1 = new Member(1L, "member1", Grade.VIP);
        memberService.join(member1);
        Member foundMember = memberService.findMember(1L);

        System.out.println(member1.getName());
        System.out.println(foundMember.getName());
    }
}
