package hellospring.firstexample.services;

import hellospring.firstexample.domain.Member;
import hellospring.firstexample.repository.MemberRepository;
import hellospring.firstexample.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        //Dependency Injection to use same repository during testing
    }


    @AfterEach
    public void afterEach(){
        memberRepository.clearStore() //Clear respository for each tesing
    }
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member testMember = memberService.findOne(saveId).get();
        //It's because findOne() returns Optional
        assertThat(member.getName()).isEqualTo(testMember.getName());
        //
    }

    @Test
    void testDuplicatedMember() {

        Member member1 = new Member();
        member1.setName("test");

        Member member2 = new Member();
        member2.setName("test");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //Occurring exception is expected when the left logic is performed.

//        IllegalStateException event = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThat(event.getMessage()).isEqualTo("Already Existed Member");

    }

    @Test
    void findOne() {
    }
}
