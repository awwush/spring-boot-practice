package com.codingshuttle.springbootpractice.module1;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    Frosting frosting;
    Syrup syrup;

    // Constructor level DI
    CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println("Baking Cake with:");
        System.out.println(frosting.getFrostingType());
        System.out.println(syrup.getSyrupType());
    }
}
