package com.jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //final있는 필드의 생성자만 만들어줌
@Transactional/* (readOnly = true) */ //spring어노테이션 사용 추천. 만약 모든 메소드가 읽기 전용이라면 여기서 붙여줘도됨
public class MemberService {

     private final MemberRepository memberRepository; 

     // @Autowired //최신버전에선 없어도됨 자동으로 넣어줌
     // public MemberService(MemberRepository memberRepository){
     //      this.memberRepository = memberRepository;
     // } //생성자를 통해 설정하는 방법. 권장방법
     //위에 @RequiredArgsConstructor를 써서 주석처리함. 같은거임

     //회원가입
     public Long join(Member member){
          validateDuplicateMember(member);
          memberRepository.save(member);   
          return member.getId();  
     }
     
     private void validateDuplicateMember(Member member) {
          List<Member> findMembers= memberRepository.findByName(member.getName());
          if(!findMembers.isEmpty()){
               throw new IllegalStateException("이미 존재하는 회원입니다.");
          }
     }
     //회원 전체 조회
     @Transactional(readOnly = true) //읽기 모드. 데이터 변경안됨(성능상 좋음)
     public List<Member> findMembers(){
          return memberRepository.findAll();
     }
     @Transactional(readOnly = true) //읽기 모드. 데이터 변경안됨(성능상 좋음)
     public Member findOne(Long memberId){
          return memberRepository.findOne(memberId);
     }
}
