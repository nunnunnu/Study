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
        t.setName("teamG");
        em.persist(t);

        Member m = new Member();
        m.setUsername("member7");
        em.persist(m);
        t.addMember(m);
        em.flush();
        em.clear();
        System.out.println(m);
        Team findTeam = em.find(Team.class, t.getId());
        List<Member> members = findTeam.getMembers();
        Member findMember = em.find(Member.class, m.getId());
        // Team team = findMember.getTeam();
        // List<Member> members = findMember.getTeam().getMembers();
        System.out.println("== ============");
        System.out.println("members = "+ findTeam);
        System.out.println("==============");
        for(Member mem : members){
            System.out.println(mem);
        }
        
        tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
