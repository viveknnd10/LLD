package com.src.splitwise.splittype;

import com.src.splitwise.model.Expense;
import com.src.splitwise.model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class PercentageSplit implements ISplitType{
    @Override
    public void calculateAmount(Expense expense, ArrayList<User> members) {
            for(Map.Entry<User,Integer> entry:expense.getSplitWith().entrySet()){
                double amount = (expense.getAmount() * entry.getValue()) / 100;
                try{
                    if(!Objects.equals(entry.getKey(), expense.getPaidBy())){
                        entry.getKey().getBalance().addToNegativeBalance(entry.getKey(),amount);
                        expense.getPaidBy().getBalance().addToPositiveBalance(expense.getPaidBy(), amount);
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
