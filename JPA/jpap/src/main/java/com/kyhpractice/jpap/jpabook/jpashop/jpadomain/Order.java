package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;
    private int orderAmount;
    @Embedded
    private Address address;
    @ManyToOne @JoinColumn(name="PRODUCT_ID")
    private Product product;
    // @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="MEMBER_ID")
    // private Member member;
    // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    // @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "DELIVERY_ID")
    // private Delivery delivery;

    // private LocalDateTime orderDate;
    // @Enumerated(EnumType.STRING)
    // private OrderStatus status;
    
    // public Member getMember() {
    //     return this.member;
    // }

    // public void setMember(Member member) {
    //     this.member = member;
    // }
    // public Long getId() {
    //     return this.id;
    // }
    
    public void setId(Long id) {
        this.id = id;
    }

    // public LocalDateTime getOrderDate() {
    //     return this.orderDate;
    // }

    // public void setOrderDate(LocalDateTime orderDate) {
    //     this.orderDate = orderDate;
    // }

    // public OrderStatus getStatus() {
    //     return this.status;
    // }

    // public void setStatus(OrderStatus status) {
    //     this.status = status;
    // }

    // public void addOrderItem(OrderItem orderitem){
    //     orderItems.add(orderitem);
    //     orderitem.setOrder(this);
    // }
    
}
