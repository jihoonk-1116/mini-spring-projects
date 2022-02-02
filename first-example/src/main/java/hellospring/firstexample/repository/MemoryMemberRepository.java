package hellospring.firstexample.repository;

import hellospring.firstexample.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //In case of Null, use Optional to handle null data in service class
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //if it's null, return it as Optional type
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //Return store map's all member
    }

    public void clearStore(){
        store.clear();
    }
}
