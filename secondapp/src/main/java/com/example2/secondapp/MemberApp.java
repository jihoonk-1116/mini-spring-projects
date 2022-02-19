package com.example2.secondapp;

import com.example2.secondapp.member.Grade;
import com.example2.secondapp.member.Member;
import com.example2.secondapp.member.MemberService;
import com.example2.secondapp.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(1L, "member1", Grade.VIP);
        memberService.join(member1);
        Member foundMember = memberService.findMember(1L);

        System.out.println(member1.getName());
        System.out.println(foundMember.getName());
    }
}
