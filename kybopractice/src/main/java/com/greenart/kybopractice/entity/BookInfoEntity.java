package com.greenart.kybopractice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_info")
public class BookInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bi_seq") private Long bookSeq;
    @Column(name = "bi_title") private String booktitle;
    @Column(name = "bi_price") private Integer bookPrice;
    @Column(name = "bi_discount") private Double bookdiscount;
    @Column(name = "bi_delivery") private String bookDelivery;
    @Column(name = "bi_reg_dt") private Date BookRegDt;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="bi_pi_seq") @JsonIgnore private PublisherInfoEntity publisherSeq;
    @ManyToOne @JoinColumn(name="bi_ti_seq") private BookTranslatorEntity translatorSeq;
    @Column(name = "bi_sales") private Integer bookSales;
} 