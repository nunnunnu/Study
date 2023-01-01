package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

    @BatchSize(size=100)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    public List<Member> getMembers() {
        return this.members;
    }

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
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

    @Override
    public String toString(){
        return "";
    }

}
