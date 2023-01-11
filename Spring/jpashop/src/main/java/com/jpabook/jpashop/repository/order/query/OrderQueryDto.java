package com.jpabook.jpashop.repository.order.query;

import java.time.LocalDateTime;
import java.util.List;

import com.jpabook.jpashop.domain.Address;
import com.jpabook.jpashop.domain.OrderStatus;

import lombok.Data;

@Data
public class OrderQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Address address;
    private List<OrderItemQueryDto> orderItems;

    public OrderQueryDto(Long orderId, String name, LocalDateTime order, OrderStatus status, Address address){
        this.orderId = orderId;
        this.name = name;
        this.orderDate = order;
        this.status=status;
        this.address = address;
    }
    
}
