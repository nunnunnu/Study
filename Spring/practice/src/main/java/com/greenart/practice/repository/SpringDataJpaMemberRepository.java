package com.greenart.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.practice.domain.Member;
import com.greenart.practice.domain.MemberRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    Optional<Member> findByName(String name);
}