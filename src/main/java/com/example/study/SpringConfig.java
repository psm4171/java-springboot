package com.example.study;

import com.example.study.repository.MemberRepository;
import com.example.study.repository.MemoryMemberRepository;
import com.example.study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 서비스와 레포지토리를 빈 등록
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }



}
