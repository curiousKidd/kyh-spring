package hello.hellospring.Service;

import hello.hellospring.Service.impl.MemberServiceImpl;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberServiceImplTest {

    MemberServiceImpl memberService = new MemberServiceImpl();

    @AfterEach
    public void atterEach() {
        memberService.clear();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        memberService.save(member);

        Member result = memberService.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.save(member2);

        Member result = memberService.findById(member1.getId()).get();

        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findByAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberService.save(member2);

        List<Member> result = memberService.findAll();

        Assertions.assertEquals(member1, result.get(0));

    }


}
