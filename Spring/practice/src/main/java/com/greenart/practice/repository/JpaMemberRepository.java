package com.greenart.practice.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.greenart.practice.domain.Member;
import com.greenart.practice.domain.MemberRepository;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
    this.em = em;
    } //자동으로 만들어짐

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
        }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
        }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); 
        //"select m from Member m" - jpql 쿼리 언어. 테이블대상이아니고 객체 대상으로 쿼리를 날림. 
        //member entity를 향해 쿼리를 날림. member m은 member as m의 줄임말. 그래서 select m은 member entity 객체 자체를 가져온다는 말임. *랑 같은말인듯?
    } 
    
}
