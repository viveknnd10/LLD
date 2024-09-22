package com.src.coffeemachine.model;

public interface Ingredient {
    void use(int amount);
    void add(int amount);
    int getQuantity();
}
