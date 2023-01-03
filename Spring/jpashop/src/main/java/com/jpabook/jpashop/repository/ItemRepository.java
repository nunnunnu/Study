package com.jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpabook.jpashop.domain.item.Item;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;
    
    public void save(Item item){
        if(item.getId()==null){ //DB에 저장된적없는 순수한 객체이면
            em.persist(item); //DB저장
        }else{
            em.merge(item); //업데이트같은 느낌
        }   
    }
    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
