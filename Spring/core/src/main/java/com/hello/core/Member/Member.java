package com.hello.core.Member;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String name;
    private Grade grade;
}