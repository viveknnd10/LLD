package com.src.coffeemachine.businesslogic;

import com.src.coffeemachine.model.Ingredient;
import com.src.coffeemachine.model.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Item,Ingredient> ingredients = new HashMap<>();

    public Inventory(){
    }

    public void addIngredient(Item Item, Ingredient ingredient){
        this.ingredients.put(Item, ingredient);
    }

    //check if the ingredient is available
    public boolean isIngredientAvailable(Item item, int amount){
        if(ingredients.containsKey(item)){
            return ingredients.get(item).getQuantity()>=amount;
        }
        throw new IllegalArgumentException("Ingredient not found");
    }

    public void useIngredient(Item item, int amount){
        if(isIngredientAvailable(item,amount)){
            ingredients.get(item).use(amount);
        }
    }

    public void updateInventory(Item Item, int amount){
        if(ingredients.containsKey(Item)) {
            ingredients.get(Item).add(amount);
        }
        }

    public void showIngredients(){
        for(Map.Entry<Item,Ingredient> entry: ingredients.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().getQuantity());
        }
    }
}
