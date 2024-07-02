package com.saurabhorg.bakery.shop;

import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup{
    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}
