package com.jpabook.jpashop.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpabook.jpashop.domain.Address;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderSearch;
import com.jpabook.jpashop.domain.OrderStatus;
import com.jpabook.jpashop.repository.OrderRepository;
import com.jpabook.jpashop.repository.OrderSimpleQueryDto;
import com.jpabook.jpashop.repository.order.simpleQuery.OrderSimpleQueryRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderSimpleApoController {
    private final OrderRepository orderRepository;
    private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> orderV1(){
        List<Order> all = orderRepository.findAllByString(new OrderSearch());

        return all;
    }
    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> orderV2(){
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());

        List<SimpleOrderDto> result = orders.stream().map(o-> new SimpleOrderDto(o)).collect(Collectors.toList());

        return result;
    }
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> orderV3(){
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        
        List<SimpleOrderDto> result = orders.stream().map(o-> new SimpleOrderDto(o)).collect(Collectors.toList());

        return result;
    }
    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> orderV4(){
        return orderSimpleQueryRepository.findOrderDto();
    }

    @Data
    static class SimpleOrderDto{
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        
        public SimpleOrderDto(Order order){
            orderId=order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
        }
    }
}
