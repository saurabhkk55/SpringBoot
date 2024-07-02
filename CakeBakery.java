package com.saurabhorg.bakery.shop;

import org.springframework.stereotype.Component;

@Component
public class CakeBakery {
    private Frosting frosting;
    private Syrup syrup;

//  Constructor dependency injection
    public CakeBakery(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println("Baking a cake with " + frosting.getFrostingType() + " and " + syrup.getSyrupType());
    }
}
