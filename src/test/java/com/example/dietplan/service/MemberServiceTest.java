package com.example.dietplan.service;

import com.example.dietplan.domain.GoalCalorie;
import com.example.dietplan.domain.Member;
import com.example.dietplan.domain.Nutri;
import com.example.dietplan.domain.calcorieEnum.ActivityLevel;
import com.example.dietplan.domain.calcorieEnum.Gender;
import com.example.dietplan.domain.calcorieEnum.Purpose;
import com.example.dietplan.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void joinMember() throws Exception {
        //given
        Member member = new Member("MemberA");

        //when
        Long savedMemberId = memberService.join(member);

        //then
        Assertions.assertThat(savedMemberId).isEqualTo(member.getId());
    }

    @Test
    void joinValidate() throws Exception {
        //given
        Member member = new Member("MemberA");
        Member duplicatedMember = new Member("MemberA");

        //when
        memberService.join(member);

        //then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(duplicatedMember);
        });
    }

    @Test
    void findOne() throws Exception {
        //given
        Member member = new Member("MemberA");

        //when
        memberService.join(member);
        Member findMember = memberService.findOne(member.getId());

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() throws Exception {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();

        //when
        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        List<Member> members = memberService.findAll();

        //then
        Assertions.assertThat(members.size()).isEqualTo(3);
    }

    @Test
    void calculateCalorie() throws Exception {
        //given
        Member member = new Member();
        member.setGender(Gender.MALE);
        member.setAge(23);
        member.setWeight(70);
        member.setHeight(172);
        member.setActivityLevel(ActivityLevel.VERYMANY);
        member.setPurpose(Purpose.GAIN);
        memberService.join(member);
        Member findMember = memberService.findOne(member.getId());
        GoalCalorie goalCalorie = new GoalCalorie();

        //when
        Nutri needCalorie = memberService.calculateCalorie(member.getId(), goalCalorie);
        
        //then
        System.out.println("needCalorie.getTotalCalorie() = " + needCalorie.getTotalCalorie());
        System.out.println("needCalorie.getCarbohydrate() = " + (needCalorie.getCarbohydrate() / 4));
        System.out.println("needCalorie.getProtein() = " + (needCalorie.getProtein() / 4));
        System.out.println("needCalorie.getFat() = " + (needCalorie.getFat() / 9));
    }
}