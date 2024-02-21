package com.example.study.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Transactional // test를 실행할 때, 트랜잭션을 먼저 실행한 후 DB에 데이터를 insert query를 다 넣은 후 테스트가 끝나면 롤백을 해준다.
// DB에 넣었던 데이터가 반영이 안된다 -> 즉, 다음 테스트 코드를 확인할 수 있다.
public class MemberServiceIntegTest {

    @Autowired // 테스트 케이스의 경우 필드 기반 Autowirde가 편리함
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void join(){
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

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. ");
    }


}
