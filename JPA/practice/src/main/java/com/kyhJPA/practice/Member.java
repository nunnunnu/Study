package com.kyhJPA.practice;

import javax.persistence.*;
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    
    // @Column(name = "TEAM_ID")
    // private Long teamId;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Team getTeam() {
        return this.team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    // public Long getTeamId() {
    //     return this.teamId;
    // }

    // public void setTeamId(Long teamId) {
    //     this.teamId = teamId;
    // }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return id+","+username+","+team.getName()+","+team.getId();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Member(){

    }
    
}