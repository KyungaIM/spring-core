package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }
    @Test
    void join(){
        Member member = new Member(1L,"test",Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        Assertions.assertEquals(member,findMember);
    }
}
