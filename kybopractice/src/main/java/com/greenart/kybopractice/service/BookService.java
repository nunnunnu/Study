package com.greenart.kybopractice.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.kybopractice.entity.BookEntity;
import com.greenart.kybopractice.repository.BookRepositroy;
@Service
public class BookService {
    @Autowired BookRepositroy bookRepo;

    public Map<String, Object> showDetailBookInfo(Long seq, Pageable page){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(bookRepo.count()==0){
            map.put("status", false);
            map.put("message", "아직 등록된 책이 존재하지않습니다.");
            map.put("code", HttpStatus.NO_CONTENT); 
        }else{
            BookEntity book = bookRepo.findBySeq(seq);
            if(book==null){
                map.put("status", false);
                map.put("message", "일치하는 책이 존재하지 않습니다. 책번호를 다시 확인해주세요");
                map.put("code", HttpStatus.BAD_REQUEST);
            }else{
                map.put("status", true);
                map.put("message", "책을 조회했습니다.");
                map.put("code", HttpStatus.OK);
                map.put("bookInfo", book);
            }
        }
        return map;
    }
    public Map<String, Object> bookBestList(Pageable page){
        Map<String, Object> map = new LinkedHashMap<>();
        if(bookRepo.count()==0){
            map.put("status", false);
            map.put("message", "아직 등록된 책이 존재하지않습니다.");
            map.put("code", HttpStatus.NO_CONTENT); 
        }else{
            map.put("status", true);
            map.put("message", "베스트 리스트 조회를 성공했습니다.");
            map.put("list", bookRepo.findAllByOrderBySalesDesc(page));
            map.put("code", HttpStatus.OK); 
        }
        return map;
    }
}