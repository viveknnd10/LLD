package com.src;

import com.src.coffeemachine.businesslogic.CoffeeMachine;
import com.src.coffeemachine.businesslogic.CoffeeType;
import com.src.coffeemachine.businesslogic.Inventory;
import com.src.coffeemachine.model.*;


//command to run this code : mvn exec:java -Dexec.mainClass="com.src.Main"
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addIngredient(Item.Milk, new Milk(1400));
        inventory.addIngredient(Item.Sugar, new Sugar(400));
        inventory.addIngredient(Item.Coffee, new CoffeePowder(400));
        inventory.addIngredient(Item.Water, new Water(1400));
        CoffeeMachine coffeeMachine = new CoffeeMachine(inventory);
        coffeeMachine.getCoffee(CoffeeType.Espresso);
        coffeeMachine.getCoffee(CoffeeType.Latte);
        coffeeMachine.DisplayCurrentIngredients();
    }
}