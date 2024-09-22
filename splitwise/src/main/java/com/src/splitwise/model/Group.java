package com.src.splitwise.model;

import com.src.splitwise.splittype.ISplitType;
import com.src.splitwise.splittype.SplitType;
import com.src.splitwise.splittype.SplitTypeFactory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public class Group {
    private final String groupId;
    private final String groupName;
    private final ArrayList<User> members;
    private final ArrayList<Expense> expenses;

    public Group(String groupName){
        this.groupName = groupName;
        Random random = new Random();
        this.groupId= String.valueOf(random.nextInt());
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }
    public void addExpense(Expense expense, SplitType splitType) {
        expenses.add(expense);
        SplitTypeFactory splitTypeFactory = new SplitTypeFactory();
        ISplitType split = splitTypeFactory.getSplitType(splitType);
        split.calculateAmount(expense,members);
    }

    public void settleBalance(User paidBy, User paidTo, Double amount){
        Settle settleBalance = new Settle(amount, paidTo, paidBy);
        settleBalance.settleNegativeBalance();
    }

    public void showBalance(User user){
        Balance balance = user.getBalance();
        balance.displayBalance();
    }

    public void showBalanceOfAllMembers(){
        for(User user: members){
            showBalance(user);
        }
    }

}
