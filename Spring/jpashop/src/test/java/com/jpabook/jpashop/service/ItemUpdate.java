package com.jpabook.jpashop.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpabook.jpashop.domain.item.Book;

@SpringBootTest
public class ItemUpdate {
    @Autowired EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        //TX
        book.setName("assada"); //변경감지로 자동으로 변경된 값이 업데이트됨 - dirty checking
        
    }
}
