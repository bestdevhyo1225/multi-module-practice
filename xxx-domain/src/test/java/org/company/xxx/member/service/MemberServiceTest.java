package org.company.xxx.member.service;

import org.company.xxx.member.domain.Member;
import org.company.xxx.member.domain.MemberRepository;
import org.company.xxx.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("멤버 테스트")
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    private Member memberFixture = Member.builder()
                                        .email("test@gmail.com")
                                        .name("hyoseok")
                                        .phoneNumber("010-1234-4567")
                                        .build();

    @Test
    @DisplayName("멤버를 저장한다.")
    public void create() {
        // given
        given(memberRepository.save(memberFixture)).willReturn(memberFixture);

        // when
        Member savedMember = memberService.create(memberFixture);

        // then
        assertThat(savedMember.getEmail()).isEqualTo(memberFixture.getEmail());
        assertThat(savedMember.getName()).isEqualTo(memberFixture.getName());
        assertThat(savedMember.getPhoneNumber()).isEqualTo(memberFixture.getPhoneNumber());
    }

    @Test
    @DisplayName("멤버 아이디로 조회한다.")
    public void getMemberById() {
        // given
        Long memberIdFixture = 1L;
        given(memberRepository.findById(memberIdFixture)).willReturn(Optional.of(memberFixture));

        // when
        Member searchedMember = memberService.getMemberById(memberIdFixture);

        // then
        assertThat(searchedMember.getEmail()).isEqualTo(memberFixture.getEmail());
        assertThat(searchedMember.getName()).isEqualTo(memberFixture.getName());
        assertThat(searchedMember.getPhoneNumber()).isEqualTo(memberFixture.getPhoneNumber());
    }
}
