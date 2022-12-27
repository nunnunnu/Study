package com.kyhJPA.practice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") //Member클래스의 멤버변수 team과 연결되어있
    private List<Member> members = new ArrayList<Member>();

    public List<Member> getMembers() {
        return this.members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
