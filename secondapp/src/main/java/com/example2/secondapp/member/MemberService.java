package com.example2.secondapp.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
