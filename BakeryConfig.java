package com.saurabhorg.bakery.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BakeryConfig {

    @Bean
    public Frosting frosting() {
//        return new ChocolateFrosting();
        return new StrawberryFrosting();
    }

    @Bean
    public Syrup syrup() {
//        return new ChocolateSyrup();
        return new StrawberrySyrup();
    }
}
