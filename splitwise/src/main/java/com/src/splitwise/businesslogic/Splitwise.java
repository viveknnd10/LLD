package com.src.splitwise.businesslogic;

import com.src.splitwise.model.Expense;
import com.src.splitwise.model.Group;
import com.src.splitwise.model.User;
import com.src.splitwise.splittype.SplitType;

import java.util.HashMap;

public class Splitwise {
    private final HashMap<String, Group> groups;
    private final HashMap<String, User> users;
    public Splitwise(){
        groups = new HashMap<>();
        users = new HashMap<>();
    }
    public Group createGroup(String groupId){
        Group group = new Group(groupId);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

    public User getUser(String userName){
        return users.get(userName);
    }

    public void addMemberToGroup(Group group, User user){
        group.addMember(user);
    }

    public void addExpenseToGroup(Group group, Expense expense, SplitType splitType){
        group.addExpense(expense, splitType);
    }

    public void settleBalance(Group group, User paidBy, User paidTo, Double amount){
        group.settleBalance(paidBy, paidTo, amount);
    }
    public void showBalance(Group group, User user){
        group.showBalanceOfAllMembers();
    }
}
