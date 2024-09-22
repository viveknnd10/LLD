package com.src.coffeemachine.businesslogic;

import com.src.coffeemachine.coffeeType.Coffee;
import com.src.coffeemachine.coffeeType.CoffeeMachineFactoryImpl;
import com.src.coffeemachine.model.Item;

public class CoffeeMachine {
    private final Inventory inventory;
    private final CoffeeMachineFactoryImpl coffeeMachineFactory;
    public CoffeeMachine(Inventory inventory) {
        this.inventory = inventory;
        coffeeMachineFactory = new CoffeeMachineFactoryImpl(inventory);
    }

    public void DisplayCurrentIngredients(){
        inventory.showIngredients();
    }

    public void getCoffee(CoffeeType type){
        Coffee current = coffeeMachineFactory.coffeeType(type);
        current.makeCoffee();
    }

    public void addIngredient(Item Item, int amount){
        inventory.updateInventory(Item,amount);
    }
}
