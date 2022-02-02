package hellospring.firstexample;

import hellospring.firstexample.repository.MemberRepository;
import hellospring.firstexample.repository.MemoryMemberRepository;
import hellospring.firstexample.services.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

//Register Spring Bean manually
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
