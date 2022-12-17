package com.greenart.kybopractice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.greenart.kybopractice.service.BookService;
import com.greenart.kybopractice.service.ReviewService;

@RestController
@RequestMapping("/api/book")
public class bookController {
    @Autowired BookService bService;
    @Autowired ReviewService rService;
    @GetMapping("/detail")
    public ResponseEntity<Object> detailBookInfo(@RequestParam Long seq,
        @PageableDefault(size=5, sort="reviewDate",direction = Sort.Direction.DESC)  final Pageable page
    ){
        Map<String, Object> map = bService.showDetailBookInfo(seq, page);
        map.put("review", rService.showReview(seq, page));
        return new ResponseEntity<>(map, (HttpStatus)map.get("code"));
    }
    @GetMapping("/list")
    public ResponseEntity<Object> detailBookInfo(
        @PageableDefault(size=10, sort="sales",direction = Sort.Direction.DESC)  final Pageable page
    ){
        Map<String, Object> map = bService.bookBestList(page);
        return new ResponseEntity<>(map, (HttpStatus)map.get("code"));
    }
    
    
}
