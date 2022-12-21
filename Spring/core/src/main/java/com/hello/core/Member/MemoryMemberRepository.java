package com.hello.core.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    //Hash맵을 사용하면 동시성 이유발생 위험 있음. 콘커러테이션맵?을 쓰라고함

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberid) {
        return store.get(memberid);
    }
    
}
