package com.src.coffeemachine.model;

import lombok.Getter;

public class CoffeePowder implements Ingredient {
    private static final int MAX_QUANTITY = 1500;
    @Getter
    private int Quantity;
    public CoffeePowder(int quantity){
        if(quantity > MAX_QUANTITY){
            throw new IllegalArgumentException("Quantity cannot be more than " + MAX_QUANTITY);
        }
        this.Quantity = quantity;
    }
    @Override
    public void use(int amount){
        if(amount > Quantity){
            throw new IllegalArgumentException("Not enough milk in the container");
        }
        Quantity -= amount;
    }
    @Override
    public void add(int amount){
        if(amount + Quantity > MAX_QUANTITY){
            throw new IllegalArgumentException("Cannot add more than " + MAX_QUANTITY + " milliliters");
        }
        Quantity += amount;
    }
}
