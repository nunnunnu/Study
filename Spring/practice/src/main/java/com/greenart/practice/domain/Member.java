package com.greenart.practice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 번호. auto_increment같은거 말하는듯?
    private Long id;

    // @Column(name = "username") //컬럼명이 다를 때 매칭시켜줌
    private String name;
    
}
