package com.example.dietplan.repository;

import com.example.dietplan.domain.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    void memberSave() throws Exception {
        //given
        Member memberA = new Member("MemberA");
        Member memberB = new Member("MemberB");
        Member memberC = new Member("MemberB");

        //when
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        memberRepository.save(memberC);

        List<Member> findMembers = memberRepository.findAll();
        List<Member> findMembersByName = memberRepository.findByName("MemberB");
        Member findMemberC = memberRepository.findOne(memberC.getId());

        //then
        assertThat(findMembers.size()).isEqualTo(3);
        assertThat(findMembersByName.size()).isEqualTo(2);
        assertThat(memberC.getUsername()).isEqualTo(findMemberC.getUsername());
    }
}