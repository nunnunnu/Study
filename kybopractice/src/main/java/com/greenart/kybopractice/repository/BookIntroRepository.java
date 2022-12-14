package com.greenart.kybopractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.kybopractice.entity.BookInfoEntity;
import com.greenart.kybopractice.entity.BookIntroEntity;
@Repository
public interface BookIntroRepository extends JpaRepository<BookIntroEntity, Long> {

}
