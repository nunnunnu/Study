package com.greenart.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.greenart.practice.domain.Member;
import com.greenart.practice.domain.MemberRepository;
@Transactional
public class MemberService {
    private static MemberRepository memberRepository;
    
    // @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public Long join(Member member) {
        //같은 이름x
        // Optional<Member> result = memberRepository.findByName(member.getName()); 
        //Optional을 바로 반환하는 것을 권장하지 않음(아래 메소드 참고)        
        validateDuplicateMember(member);

        //null이 들어올 확률이 있어서 Optional로 감싸줌. .get으로 바로 꺼내도 되나 권장하지 않음
        //.orElseGet(값이 있으면 꺼내고 값이 없으면 메소드를 실행하거나 디폴트값을 꺼냄)을 써도됨. 
        
        // result.ifPresent(m->{throw new IllegalStateException("이미 존재하는 회원입니다."); // - 위에써서 주석처리함
        // })/; //일치하는 회원이 있다면 로직이 동작
        memberRepository.save(member);
        return member.getId();
    } //jpa는 데이터 변경이 모두 Transactional안에서 이루어져야함. 여기선 @Transactional이 join메소드에만 붙어도 되지만 일단 class에 붙여줌

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
        throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    //전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
        }
    public Optional<Member> findOne(Long memberId) throws Exception {
    return memberRepository.findById(memberId);
    }
}