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
            // Member m1 = em.find(Member.class, 150L);
            // m1.setName("AAAAAAA");
            
            // // em.detach(m1);
            // em.clear();
            // Member m2 = em.find(Member.class, 150L);

            // System.out.println("=================");
            // tx.commit();
            // System.out.println("=================");
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
