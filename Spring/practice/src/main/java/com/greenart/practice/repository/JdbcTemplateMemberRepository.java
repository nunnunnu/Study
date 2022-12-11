package com.greenart.practice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.greenart.practice.domain.Member;
import com.greenart.practice.domain.MemberRepository;

public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    // @Autowired //생성자 하나일시 생략 가능
    public JdbcTemplateMemberRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id"); //sql문 작성할 필요없음. member테이블의 id에 insert해

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id)  {
        List<Member> result = jdbcTemplate.query("select * from member where id=?",memberRowMapper(), id );
        return result.stream().findAny(); //순수 jdbc와 같은 코드
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name=?",memberRowMapper(), name );
        return result.stream().findAny(); //순수 jdbc와 같은 코드
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member",memberRowMapper() );
    }
    private RowMapper<Member> memberRowMapper(){
        // return new RowMapper<Member>(){
        //     @Override
        //     public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
        //         Member member = new Member();
        //         member.setId(rs.getLong("id"));
        //         member.setName(rs.getString("name"));
        //         return member;
        //     } //람다로 변환 가능
            return (rs, rowNum) -> {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return member;
        };
    }
}
