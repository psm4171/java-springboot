package com.example.study.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;
import com.example.study.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void join() {
        Member member = new Member();
        member.setName("psm");

        Long saveId = memberService.join(member);

        Member findMember =  memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateException(){
        Member member1 = new Member();
        member1.setName("psm");

        Member member2 = new Member();
        member2.setName("psm");

        memberService.join(member1);
     //   assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");

       /* try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다. ");
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("")
        }*/


    }

    @Test
    public void findAllMembers() {

    }

    @Test
    public void findOne() {
    }
}