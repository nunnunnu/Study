package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item{
    private String director;
    private String actor;

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return this.actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

}
