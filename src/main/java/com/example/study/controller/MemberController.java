package com.example.study.controller;

import com.example.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 객체를 생성해서 스프링이 들고 있다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에서 스프링이 멤버 서비스를 연결 - 컨트롤러와 서비스의 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }





}
