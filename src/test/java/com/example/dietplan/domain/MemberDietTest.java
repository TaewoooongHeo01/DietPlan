package com.example.dietplan.domain;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberDietTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void memberDietTest() throws Exception {
        //given
        Member member = new Member("MemberA");
        Diet diet = new Diet("dietA");
        member.addDiet(diet);

        Member member1 = new Member();
        Member member2 = new Member();

        em.persist(member);
        em.persist(diet);
        em.persist(member1);
        em.persist(member2);
        em.flush();
        em.clear();

        System.out.println("==== diet ====");
        Diet reference = em.getReference(Diet.class, diet.getId());
        Diet findDiet = em.find(Diet.class, diet.getId());
        System.out.println(findDiet.getClass());

        System.out.println("==== member ====");
        String memberName = findDiet.getMember().getUsername();
        System.out.println("memberName = " + memberName);

    }
}
