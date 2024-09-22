package com.src.coffeemachine.coffeeType;

import com.src.coffeemachine.businesslogic.Inventory;
import com.src.coffeemachine.model.Item;

public class MochaLatte implements Coffee {
    private final Inventory inventory;

    MochaLatte(Inventory inventory){
        this.inventory = inventory;
    }
    @Override
    public void makeCoffee() {
        inventory.useIngredient(Item.Milk,50);
        inventory.useIngredient(Item.Water,5);
        inventory.useIngredient(Item.Coffee,20);
        inventory.useIngredient(Item.Sugar,15);
        System.out.println("Mocha Latte is ready");
    }
}
