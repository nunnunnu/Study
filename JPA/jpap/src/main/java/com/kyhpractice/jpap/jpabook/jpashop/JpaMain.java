package com.kyhpractice.jpap.jpabook.jpashop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.kyhpractice.jpap.jpabook.jpashop.jpadomain.Address;
import com.kyhpractice.jpap.jpabook.jpashop.jpadomain.Member;
import com.kyhpractice.jpap.jpabook.jpashop.jpadomain.MemberDTO;
import com.kyhpractice.jpap.jpabook.jpashop.jpadomain.Team;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Team t1 = new Team();
            t1.setName("team1");
            em.persist(t1);
            Member m = new Member();
            m.setName("member1");
            m.setAge(10);
            m.setTeam(t1);
            em.persist(m);
            Team t2 = new Team();
            t2.setName("team2");
            em.persist(t2);
            Member m2 = new Member();
            m2.setName("member2");
            m2.setAge(15);
            m2.setTeam(t2);
            em.persist(m2);
            Member m3 = new Member();
            m3.setName("member3");
            m3.setAge(18);
            m3.setTeam(t2);
            em.persist(m3);

            em.flush();
            em.clear();
            
            int count = em.createQuery("update Member m set m.age = 20").executeUpdate();
            m = em.find(Member.class, m.getId());
            m2 = em.find(Member.class, m2.getId());
            m3 = em.find(Member.class, m3.getId());
            em.clear();
            System.out.println(count);

            System.out.println(m.getAge());
            System.out.println(m2.getAge());
            System.out.println(m3.getAge());

            // for(Member member : result){
            //     System.out.println(member);
            // }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        emf.close();
    }
}
