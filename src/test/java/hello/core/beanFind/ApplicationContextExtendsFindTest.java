package hello.core.beanFind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상일 때 오류가 발생한다")
    void findBeanByTypeDuplicated() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->
                ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상일 때 이름으로 검색한다")
    void findBeanByName() {
        DiscountPolicy bean = ac.getBean("fixDiscountPolicy",DiscountPolicy.class);
        Assertions.assertInstanceOf(DiscountPolicy.class,bean);
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
    static class TestConfig {
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
    }
}
