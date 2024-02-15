package com.example.study.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.study.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 데이터를 테스트하면 깔끔하게 끝날때마다 지워지는 역할이 필요하다. 객체에 생성된 데이터의 중복이 발생하기 때문에
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("psm");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById() {
        Member member = new Member();
        member.setId(1L);
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("psm");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kkk");
        repository.save(member2);

        Member result = repository.findByName("psm").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("psm");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ppp");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}