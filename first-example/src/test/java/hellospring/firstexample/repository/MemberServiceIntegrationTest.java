package hellospring.firstexample.repository;

import hellospring.firstexample.domain.Member;
import hellospring.firstexample.services.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional

public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void signup() throws Exception{
        //Given
        Member member = new Member();
        member.setName("Signup test");

        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findById(saveId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void duplicatedMember() throws Exception{
        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("Already Existed Member");
    }
}
