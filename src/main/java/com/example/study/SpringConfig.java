package com.example.study;

import com.example.study.repository.JdbcMemberRepository;
import com.example.study.repository.JdbcTemplateMemberRepository;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MemoryMemberRepository;
import com.example.study.service.MemberService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    // 서비스와 레포지토리를 빈 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
       // return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }



}
