package com.kyhJPA.practice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) //DB에는 enum타입이 없어서 붙여주는 어노테이션
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) //DB에서는 날짜타입이 DATE, TIME, TIMESTAMP 세가지가 있음. 타입을 지정해줌
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob //varchar보다 큰 데이터를 담고싶을
    private String description;
    //Getter, Setter… 
    @Transient
    private int temp;
}