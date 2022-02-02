package hellospring.firstexample.controllers;

import hellospring.firstexample.domain.Member;
import hellospring.firstexample.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return  "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
