package com.jpabook.jpashop.api;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    // @PostMapping("/api/v1/members")
    // public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
    //     Long id =  memberService.join(member);
    //     return new CreateMemberResponse(id);
    // }
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid CreateMemberRequest request){

        Member member = new Member();

        member.setName(request.getName());

        Long id =  memberService.join(member);
        return new CreateMemberResponse(id);
    }

    //회원 정보 수정
    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request){
        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(id, findMember.getName());
    }

    // @GetMapping("/api/v1/members")
    // public List<Member> membersV1() {
    //     return memberService.findMembers();
    // } //안좋은 예시. 실제로 실행해보니 무한로딩이 남. 양방향 매핑때문에..일단 @JsonIgnore를 썼는데 좋은 방법이 아님

    @GetMapping("/api/v2/members")
    public Result memberV2(){
        List<Member> findMembers = memberService.findMembers();

        List<MemberDto> collect = findMembers.stream().map(m->new MemberDto(m.getName())).collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }
    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }

    @Data
    static class UpdateMemberRequest{
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        private String name;
    }

    @Data
    static class CreateMemberRequest{
        private String name;

    }
    @Data
    static class CreateMemberResponse{
        private Long id;
        
        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}
