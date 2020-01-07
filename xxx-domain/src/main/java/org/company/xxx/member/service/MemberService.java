package org.company.xxx.member.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.company.xxx.member.domain.Member;
import org.company.xxx.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(final Member member) {
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member getMemberById(final Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException("멤버가 존재하지 않습니다."));
    }
}
