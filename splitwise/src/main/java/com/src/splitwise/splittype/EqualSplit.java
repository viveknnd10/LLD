package com.src.splitwise.splittype;

import com.src.splitwise.model.Expense;
import com.src.splitwise.model.User;

import java.util.ArrayList;
import java.util.Objects;

public class EqualSplit implements ISplitType{
    @Override
    public void calculateAmount(Expense expense, ArrayList<User> members) {
        double amount = expense.getAmount() / members.size();
        for(User user: members){
            try{
                if(!Objects.equals(user, expense.getPaidBy())){
                    user.getBalance().addToNegativeBalance(user,amount);
                    expense.getPaidBy().getBalance().addToPositiveBalance(expense.getPaidBy(), amount);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
