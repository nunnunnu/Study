package com.greenart.kybopractice.VO;

import java.util.ArrayList;
import java.util.List;

import com.greenart.kybopractice.entity.BookInfoEntity;
import com.greenart.kybopractice.entity.PublisherInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherInfoVO {
    private Long publisherSeq;
    private String publisherName;
    private List<BookInfoVO> books = new ArrayList<BookInfoVO>();

    public Long getPublisherSeq() {
        return this.publisherSeq;
    }

    public void setPublisherSeq(Long publisherSeq) {
        this.publisherSeq = publisherSeq;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<BookInfoVO> getBooks() {
        return this.books;
    }

    public void setBooks(List<BookInfoVO> books) {
        this.books = books;
    }

    public PublisherInfoVO(PublisherInfoEntity p){
        this.publisherSeq=p.getPublisherSeq();
        this.publisherName=p.getPublisherName();
        // this.books=p.getBooks();
    }
    @Override
    public String toString(){
        return publisherSeq+"/"+publisherName+"/"+books.toString();
    }

}
