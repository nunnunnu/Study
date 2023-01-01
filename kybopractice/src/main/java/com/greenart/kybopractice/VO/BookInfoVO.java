package com.greenart.kybopractice.VO;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenart.kybopractice.entity.BookInfoEntity;
import com.greenart.kybopractice.entity.BookTranslatorEntity;
import com.greenart.kybopractice.entity.PublisherInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoVO {
    private Long bookSeq;
    private String booktitle;
    private Integer bookPrice;
    private Double bookdiscount;
    private String bookDelivery;
    private Date BookRegDt;
    @JsonIgnore
    private PublisherInfoEntity publisher;
    private BookTranslatorEntity translator;
    private Integer BookSales;
    private Integer discountPrice;

    public BookInfoVO(BookInfoEntity b){
        this.bookSeq=b.getBookSeq();
        this.booktitle=b.getBooktitle();
        this.bookPrice=b.getBookPrice();
        this.bookdiscount=b.getBookdiscount();
        this.bookDelivery=b.getBookDelivery();
        this.BookRegDt=b.getBookRegDt();
        this.publisher=b.getPublisherSeq();
        this.translator=b.getTranslatorSeq();
        this.BookSales=b.getBookSales();
        this.discountPrice=(int) (b.getBookPrice()*(1-b.getBookdiscount()));
    }

}
