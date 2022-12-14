package com.greenart.kybopractice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.greenart.kybopractice.VO.BookInfoVO;
import com.greenart.kybopractice.entity.AutherInfoEntity;
import com.greenart.kybopractice.entity.BookInfoEntity;
import com.greenart.kybopractice.entity.BookIntroEntity;
import com.greenart.kybopractice.entity.BookTextIntro;
import com.greenart.kybopractice.entity.BookTranslatorEntity;
import com.greenart.kybopractice.entity.BookWriterInfo;
import com.greenart.kybopractice.entity.CoverImageEntity;
import com.greenart.kybopractice.entity.PublisherInfoEntity;
import com.greenart.kybopractice.repository.AutherInfoRepository;
import com.greenart.kybopractice.repository.BookInfoRepository;
import com.greenart.kybopractice.repository.BookIntroRepository;
import com.greenart.kybopractice.repository.BookRepositroy;
import com.greenart.kybopractice.repository.BookTextIntroRepository;
import com.greenart.kybopractice.repository.BookTranslatorRepository;
import com.greenart.kybopractice.repository.BookWriterInfoRepository;
import com.greenart.kybopractice.repository.CoverImageRepository;
import com.greenart.kybopractice.repository.PublisherInfoRepository;
@Service
public class BookService {
    @Autowired BookRepositroy bookRepo;
    @Autowired AutherInfoRepository aRepository;
    @Autowired BookTranslatorRepository tranRepository;
    @Autowired PublisherInfoRepository pRepository;
    @Autowired BookWriterInfoRepository wRepository; 
    @Autowired BookIntroRepository iRepository;
    @Autowired BookTextIntroRepository textRepository;
    @Autowired CoverImageRepository cRepository;
    @Autowired BookInfoRepository biRepo;
    @Autowired EntityManager em;

    public Map<String, Object> showDetailBookInfo(Long seq, Pageable page){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(bookRepo.count()==0){
            map.put("status", false);
            map.put("message", "?????? ????????? ?????? ????????????????????????.");
            map.put("code", HttpStatus.NO_CONTENT); 
        }else{
            BookInfoEntity book = biRepo.findByBookSeq(seq);
            if(book==null){
                map.put("status", false);
                map.put("message", "???????????? ?????? ???????????? ????????????. ???????????? ?????? ??????????????????");
                map.put("code", HttpStatus.BAD_REQUEST);
            }else{
                BookInfoVO bookVO = new BookInfoVO(book);
                System.out.println(bookVO.getDiscountPrice());
                map.put("status", true);
                map.put("message", "?????? ??????????????????.");
                map.put("code", HttpStatus.OK);
                map.put("bookInfo", bookVO);
            }
        }
        return map;
    }
    public Map<String, Object> bookBestList(Pageable page){
        Map<String, Object> map = new LinkedHashMap<>();
        if(bookRepo.count()==0){
            map.put("status", false);
            map.put("message", "?????? ????????? ?????? ????????????????????????.");
            map.put("code", HttpStatus.NO_CONTENT); 
        }else{
            map.put("status", true);
            map.put("message", "????????? ????????? ????????? ??????????????????.");
            map.put("list", biRepo.findAll(page));
            map.put("code", HttpStatus.OK); 
        }

        
        return map;
    }
    
    public void addBookInfo(
        String autherName,
        @Nullable String translatorName,
        String pubName,
        String title, Integer price, Double discount, String delivery, Date date, Integer sales,
        String introImage, String introText, String coverImage
    ){
        String[] split = autherName.split(";");
        System.out.println(split.length);
        List<AutherInfoEntity> autherList = new ArrayList<AutherInfoEntity>();
        for(String name : split){
            AutherInfoEntity auther = new AutherInfoEntity();
            auther = aRepository.findByAutherName(name);
            if(auther==null){
                auther = new AutherInfoEntity();
                auther.setAutherName(autherName);
                auther = aRepository.save(auther);
            }
            autherList.add(auther);
        }
        PublisherInfoEntity pub = pRepository.findByPublisherName(pubName);
        if(pub==null){
            pub = new PublisherInfoEntity();
            pub.setPublisherName(pubName);
            pub = pRepository.save(pub);
        }
        BookInfoEntity book = null;
        if(translatorName!=null && !translatorName.equals("null")){
            BookTranslatorEntity tran = tranRepository.findByTranslatorName(translatorName);
            if(tran==null){
                tran = new BookTranslatorEntity();
                tran.setTranslatorName(translatorName);
                tran = tranRepository.save(tran);
                // book = new BookInfoEntity(null, title, price, discount, delivery, date, pub.getPublisherSeq(), tran.getTranslatorSeq(), sales);
            }
        }else{
            // book = new BookInfoEntity(null, title, price, discount, delivery, date, pub.getPublisherSeq(), null, sales);
        }
        book = biRepo.save(book);
        System.out.println(book);
        for(AutherInfoEntity a : autherList){
            BookWriterInfo bwi = new BookWriterInfo();
            bwi.setBookSeq(book.getBookSeq());
            bwi.setAutherSeq(a.getAutherSeq());
            bwi = wRepository.save(bwi);
        }
        
        BookIntroEntity image = new BookIntroEntity();
        image.setBookSeq(book.getBookSeq());
        image.setIntroImage(introImage);
        image = iRepository.save(image);

        BookTextIntro text = new BookTextIntro();
        text.setBookSeq(book.getBookSeq());
        text.setIntroText(introText);
        text = textRepository.save(text);

        CoverImageEntity cover = new CoverImageEntity();
        cover.setBookSeq(book.getBookSeq());
        cover.setCoverImage(coverImage);
        cover = cRepository.save(cover);

    }
}
