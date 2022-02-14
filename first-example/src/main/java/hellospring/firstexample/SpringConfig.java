package hellospring.firstexample;

import hellospring.firstexample.aop.TimeTraceAOP;
import hellospring.firstexample.repository.JpaMemberRepository;
import hellospring.firstexample.repository.MemberRepository;
import hellospring.firstexample.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

//Register Spring Bean manually
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAOP timeTraceAOP(){
        return new TimeTraceAOP();
    }

//    //EntityManger injection
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    @Bean
//    public MemberRepository memberRepository(){
        //  return new JdbcMemberRepository()
////        return new MemoryMemberRepository();
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
