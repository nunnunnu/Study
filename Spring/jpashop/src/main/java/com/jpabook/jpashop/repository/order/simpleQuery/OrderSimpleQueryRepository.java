package com.jpabook.jpashop.repository.order.simpleQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpabook.jpashop.repository.OrderSimpleQueryDto;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;
    
    public List<OrderSimpleQueryDto> findOrderDto() {
        return em.createQuery("select new com.jpabook.jpashop.repository.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o "
            +"join o.member m join o.delivery d", OrderSimpleQueryDto.class).getResultList();
        //DTO가 매핑이 될 수가 없음!!자동으로 생성자에 넣어주는 기능은 없음
        //DTO의 생성자는 엔티티 자체를 파라미터로 받으면 안되고 위 쿼리문에서 나올 컬럼을 하나하나 넣어줘야함
    }
}
