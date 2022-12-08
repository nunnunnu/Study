package com.greenart.practice.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import com.greenart.practice.domain.Member;
import com.greenart.practice.domain.MemoryMemberRepository;

@Repository
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();   

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result= repository.findById(member.getId()).get(); //Optional이라서 .get() 써줌
        // System.out.println(result == member); //이렇게 비교하기 애매함
        // Assertions.assertEquals(member, result); //테스트 통과. 초록불이 들어옴
        // Assertions.assertEquals(member, null); //테스트 실패. 빨간불이 들어옴

        Assertions.assertThat(member).isEqualTo(result); //요즘에 더 많이 씀
        // 일치할때만 초록불인듯
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(member1).isEqualTo(result);
        //밑에 findAll을 추가하기 전까지 잘 작동했는데 추가후 에러가 뜸
        //findAll이 먼저 수행되었기때문에 spring1, spring2가 이미 지정되어있어서 에러가 뜸
        // -> test가 끝날때마다 공용데이터나 저장소(repository)를 지워줘야함(아래 afterEach메소드 추가로 해결. 하나의 테스트가 끝날때마다 실행됨)
    }
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
