package com.jpabook.jpashop.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpabook.jpashop.domain.Address;
import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderItem;
import com.jpabook.jpashop.domain.OrderSearch;
import com.jpabook.jpashop.domain.OrderStatus;
import com.jpabook.jpashop.repository.OrderRepository;
import com.jpabook.jpashop.repository.order.query.OrderQueryDto;
import com.jpabook.jpashop.repository.order.query.OrderQueryRepository;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    // @GetMapping("/api/v1/orders")
    // public List<Order> orderV1(){
    //     List<Order> all = orderRepository.findAllByString(new OrderSearch());
    //     for(Order order : all){
    //         order.getMember().getName();
    //         order.getDelivery().getAddress();
    //         List<OrderItem> orderItems = order.getOrderItems();
    //         orderItems.stream().forEach(o->o.getItem().getName());
    //     }
    //     return all;
    // }
    @GetMapping("/api/v2/orders")
    public List<OrderDto> orderV2(){
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDto> collect = orders.stream().map(o->new OrderDto(o)).collect(Collectors.toList());
        return collect;
    }
    
    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3(){
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> collect = orders.stream().map(o->new OrderDto(o)).collect(Collectors.toList());
        return collect;
    }
    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> ordersV3_page(
        @RequestParam(value="offset", defaultValue = "0") int offset,
        @RequestParam(value="limit", defaultValue = "100") int limit
    ){
        List<Order> orders = orderRepository.findAllWithItem(offset, limit);
        List<OrderDto> collect = orders.stream().map(o->new OrderDto(o)).collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/api/v4/orders")
    public List<OrderQueryDto> ordersV4(){
        return orderQueryRepository.findOrderQueryDtos();
    }
    
    

    @Data 
    static class OrderDto{
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order){
            this.orderId=order.getId();
            this.name=order.getMember().getName();
            this.orderDate = order.getOrderDate();
            this.orderStatus=order.getStatus();
            this.address = order.getDelivery().getAddress();
            // this.orderItems = order.getOrderItems(); //?????? ??????????????? ????????? ????????? ?????????
            //???????????? ????????? for?????? ????????? ??????????????? ??????????????????. ???????????? json?????? ????????? ?????? ????????????
            //DTO??? ?????? ?????????
            orderItems = order.getOrderItems().stream().map(OrderItem->new OrderItemDto(OrderItem)).collect(Collectors.toList());
        }
    }
    @Getter
    static class OrderItemDto{
        private String itemName;
        private int price;
        private int count;

        public OrderItemDto(OrderItem orderItem){
            this.itemName = orderItem.getItem().getName();
            this.price=orderItem.getOrderPrice();
            this.count = orderItem.getCount();
        }
    }
}
