package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFind {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 중복 타입이 있을 때 오류가 발생한다")
    void findBeanByTypeDuplicated() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->
                ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 같은 타입일 경우 이름으로 검색한다")
    void findBeanByName() {
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);
        Assertions.assertInstanceOf(MemberRepository.class,bean);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType() {
        Map<String, MemberRepository> beans = ac.getBeansOfType(MemberRepository.class);
        for(String key : beans.keySet()){
            System.out.println("key = "+ key+"value = "+beans.get(key));
        }
        Assertions.assertEquals(beans.size(),2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
