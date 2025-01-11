package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.OrderService;

public class OderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();
        Long memberId = 1L;
        int itemPrice = 10000;

        Member member = new Member(memberId, "test", Grade.VIP);
        memberService.join(member);
        orderService.createOder(memberId, "item", itemPrice);
    }
}
