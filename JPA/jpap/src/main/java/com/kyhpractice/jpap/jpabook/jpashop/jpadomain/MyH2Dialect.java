package com.kyhpractice.jpap.jpabook.jpashop.jpadomain;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

public class MyH2Dialect extends H2Dialect{
    public MyH2Dialect(){
        this.registerFunction("group_concat", new StandardSQLFunction("group_concat", new StringType()));
    }
}
