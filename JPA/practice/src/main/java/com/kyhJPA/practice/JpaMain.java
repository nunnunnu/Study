package com.kyhJPA.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
        Team t = new Team();
        t.setName("teamD");
        em.persist(t);

        Member m = new Member();
        m.setUsername("member4");
        m.setTeam(t);
        em.persist(m);
        System.out.println(m);
        Member findMember = em.find(Member.class, m.getId());
        Team team = findMember.getTeam();
        System.out.println(team);
        System.out.println(team.getName());
        
        tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
