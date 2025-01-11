package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        int itemPrice = 10000;
        Member member = new Member(memberId,"test", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOder(memberId,"item",itemPrice);
        Assertions.assertEquals(order.getDiscountPrice(),1000);
    }
}
