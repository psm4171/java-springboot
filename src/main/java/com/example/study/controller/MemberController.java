package com.example.study.controller;

import com.example.study.domain.Member;
import com.example.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 객체를 생성해서 스프링이 들고 있다.
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에서 스프링이 멤버 서비스를 연결 - 컨트롤러와 서비스의 연결 : 생성자 주입 방식
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") // 데이터를 조회할 때 Get
    public String createForm() {
        return "members/createForm";
    }

    @PostMapping("/members/new") // 데이터를 등록할 때 Post
    public String create(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);
        return "redirect:/";
    }


}
