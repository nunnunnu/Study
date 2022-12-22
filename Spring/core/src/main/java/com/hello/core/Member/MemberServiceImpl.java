package com.hello.core.Member;
// impl = 구현체가 하나만있을때 관례로 많이 쓰임
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);//MemoryMemberRepository의 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); //MemoryMemberRepository의 findById가 호출
    }
    
}
