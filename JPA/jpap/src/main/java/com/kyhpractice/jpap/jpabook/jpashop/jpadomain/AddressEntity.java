package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Address address;

    public AddressEntity(){}
    public AddressEntity(String city, String street, String zipcode){
        this.address=new Address(city, street, zipcode);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Address adrs = (Address) o;
        return Objects.equals(address.getCity(), adrs.getCity()) && 
                Objects.equals(address.getStreet(), adrs.getStreet()) &&
                Objects.equals(address.getZipcode(), adrs.getZipcode()); 
    }
}
