package hellospring.firstexample;

import hellospring.firstexample.repository.JdbcTemplateMemberRepository;
import hellospring.firstexample.repository.MemberRepository;
import hellospring.firstexample.repository.MemoryMemberRepository;
import hellospring.firstexample.services.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration

//Register Spring Bean manually
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
