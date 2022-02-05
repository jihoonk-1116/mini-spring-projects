package hellospring.firstexample.services;

import hellospring.firstexample.domain.Member;
import hellospring.firstexample.repository.MemberRepository;
import hellospring.firstexample.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){


        checkDuplicatedMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void checkDuplicatedMember(Member member) {

        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("Already Existed Member");
            });
        // Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent( m -> { //Member object is included in Optional object
//            throw new IllegalStateException("Already Existed Member...");
//        });
    }

}
