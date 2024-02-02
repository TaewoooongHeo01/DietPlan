package com.example.dietplan.service;

import com.example.dietplan.domain.GoalCalorie;
import com.example.dietplan.domain.Member;
import com.example.dietplan.domain.Nutri;
import com.example.dietplan.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) throws Exception {
        validateUser(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateUser(Member member) {
        List<Member> members = memberRepository.findByName(member.getUsername());
        for (int i = 0; i < members.toArray().length; i++) {
            if (members.get(i).getUsername().equals(member.getUsername())) {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            }
        }
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Nutri calculateCalorie(Long id, GoalCalorie goalCalorie) {
        Member findMember = memberRepository.findOne(id);
        findMember.changeGoalCalorie(goalCalorie);
        return goalCalorie.calculateCalorie();
    }
}
