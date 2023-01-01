package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(
    name="Member.findByName", //그냥 findByName해도 되나 앞에 엔티티를 붙이는 것이 관례임
    query = "select m from Member m where m.name= :name"
)   
public class Member  {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;
    @ManyToOne @JoinColumn(name = "TEAM_ID")
    private Team team;
    private int age;

    public Team getTeam(){
        return team;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //기간
    // @Embedded
    // private Period workPeriod;
    // //주소
    // @Embedded
    // private Address homeAddress;

    // @ElementCollection
    // @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    // @Column(name="FOOD_NAME") //값이 하나라 사용가능
    // private Set<String> favoriteFoods = new HashSet<String>();
    // @ElementCollection
    // @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    // // 값이 여러개라 @Column사용 불가능
    // private List<Address> addressHistory = new ArrayList<Address>();
    
    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name="MEMBER_ID")
    // private List<AddressEntity> addressHistory = new ArrayList<AddressEntity>();

    // public List<AddressEntity> getAddressHistory() {
    //     return this.addressHistory;
    // }

    // public void setAddressHistory(List<AddressEntity> addressHistory) {
    //     this.addressHistory = addressHistory;
    // }

    // public Set<String> getFavoriteFoods() {
    //     return this.favoriteFoods;
    // }

    // public void setFavoriteFoods(Set<String> favoriteFoods) {
    //     this.favoriteFoods = favoriteFoods;
    // }
    

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column = @Column(name="WORK_CITY")),
        @AttributeOverride(name="street", column = @Column(name="WORK_STREET")),
        @AttributeOverride(name="zipcode", column = @Column(name="WORK_ZIPCODE"))
    })
    private Address workAddress;

    // public Period getWorkPeriod() {
    //     return this.workPeriod;
    // }

    // public void setWorkPeriod(Period workPeriod) {
    //     this.workPeriod = workPeriod;
    // }


    // public Address getHomeAddress() {
    //     return this.homeAddress;
    // }

    // public void setHomeAddress(Address homeAddress) {
    //     this.homeAddress = homeAddress;
    // }


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

    public void setTeam(Team team) {
        this.team = team;
    }
    @Override
    public String toString(){
        return "id="+id+", name="+name+", age="+age;
    }
}
