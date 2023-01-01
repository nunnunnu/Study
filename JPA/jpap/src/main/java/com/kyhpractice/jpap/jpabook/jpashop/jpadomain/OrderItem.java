
package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class OrderItem {
    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    // @Column(name = "ORDER_ID")
    // private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="ORDER_ID")
    private Order order;

    
    // @Column(name = "ITEM_ID")
    // private Long itemId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="ITEM_ID")
    private Item item;

    
    private int orderPrice;
    
    private int count;
    
    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }


    public int getOrderPrice() {
        return this.orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
