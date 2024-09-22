package com.src.coffeemachine.coffeeType;

import com.src.coffeemachine.businesslogic.CoffeeType;
import com.src.coffeemachine.businesslogic.Inventory;

public class CoffeeMachineFactoryImpl {
    private final Inventory inventory;
    public CoffeeMachineFactoryImpl(Inventory inventory){
        this.inventory = inventory;
    }
    public Coffee coffeeType(CoffeeType type){
        return switch (type) {
            case Espresso -> new Espresso(inventory);
            case Latte -> new MochaLatte(inventory);
            default -> throw new IllegalArgumentException("the coffee type is not supported");
        };
    } 
}
