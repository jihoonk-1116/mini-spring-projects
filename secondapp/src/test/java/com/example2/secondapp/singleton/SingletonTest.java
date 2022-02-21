package com.example2.secondapp.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("1. " + singletonService1);
        System.out.println("2. " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        //same -> == , equal -> java's equal
    }
}
