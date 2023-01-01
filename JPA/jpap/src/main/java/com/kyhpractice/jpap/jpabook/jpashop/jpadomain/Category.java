package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();
    //양방향 매핑

    @ManyToMany @JoinTable(name="CATEGORY_ITEM", joinColumns = @JoinColumn(name="ITEM_ID"))
    private List<Item> items = new ArrayList<Item>(); //이렇게 쓰지 말것
}
