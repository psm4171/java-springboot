package com.example.study.repository;

import com.example.study.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional을 통해 null이면 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
