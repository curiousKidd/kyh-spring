package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    //  private final MemberRepository memberRepository = new MemoryMemberRepository(MemberRepository memberRepository);
    private final MemberRepository memberRepository;

    //  @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름 중복 회원x

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복 이름 체크
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 회원찾기 - 전체
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    /**
     * 회원찾기 - 회원Id
     */
    public Optional<Member> findOne(Long memverId) {
        return memberRepository.findById(memverId);
    }
}
