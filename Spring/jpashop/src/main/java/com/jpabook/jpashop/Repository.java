package com.jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpabook.jpashop.domain.Member;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext 
    private EntityManager em;

    public Long sava(Member member){
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
