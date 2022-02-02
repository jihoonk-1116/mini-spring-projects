package hellospring.firstexample.controllers;

import hellospring.firstexample.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //Component Scan
public class MemberController {

    private final MemberService memberService;

    @Autowired
    //Dependency Injection -> Spring brings MemberService class from Spring container
    //when MemberController is created
    //Singleton pattern
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //DI by Constructor
}
