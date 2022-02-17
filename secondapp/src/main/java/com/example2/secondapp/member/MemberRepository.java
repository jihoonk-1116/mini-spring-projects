package com.example2.secondapp.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
