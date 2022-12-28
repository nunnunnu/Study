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
            Member member = new Member();
            member.setUsername("member0");
            em.persist(member);

            Team team = new Team();
            team.setName("Team0");
            team.getMembers().add(member); //team테이블이 아닌 member테이블의 team_id에 값이 들어감 update구문 
            //권장하지 않는 이유. team을 보냈는데 member테이블이 update됨

            em.persist(team);
        
        tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
