package com.src.coffeemachine.coffeeType;

import com.src.coffeemachine.businesslogic.Inventory;
import com.src.coffeemachine.model.Item;

public class Espresso implements Coffee {
    private final Inventory inventory;

    Espresso(Inventory inventory){
        this.inventory = inventory;
    }
    @Override
    public void makeCoffee() {
        inventory.useIngredient(Item.Milk,50);
        inventory.useIngredient(Item.Water,13);
        inventory.useIngredient(Item.Coffee,15);
        inventory.useIngredient(Item.Sugar,15);
        System.out.println("Espresso is ready");
    }
}
