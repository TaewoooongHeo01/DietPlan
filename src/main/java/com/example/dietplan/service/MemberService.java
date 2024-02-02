package com.example.dietplan.service;

import com.example.dietplan.domain.*;
import com.example.dietplan.repository.FoodRepository;
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
    private final FoodRepository foodRepository;

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

    public void addDiet(Long id, Diet diet) {
        //member가 먼저 join 되어 있어야 함
        Member findMember = memberRepository.findOne(id);
        findMember.addDiet(diet);
    }

    public List<Diet> findDiets(Long memberId) {
        Member findMember = memberRepository.findOne(memberId);
        return findMember.getDiets();
    }

    //Comments를 생성할 때 member가 포함됨
    public void addComments(Long foodId, Comments comments) {
        Food findFood = foodRepository.findOne(foodId);
        findFood.addComments(comments);
    }
}
