package com.src.splitwise;

import com.src.splitwise.businesslogic.Splitwise;
import com.src.splitwise.model.Balance;
import com.src.splitwise.model.Expense;
import com.src.splitwise.model.Group;
import com.src.splitwise.model.User;
import com.src.splitwise.splittype.SplitType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Splitwise splitwise = new Splitwise();
        Group AmitsPartyGroup = splitwise.createGroup("AmitsParty");
        Random random = new Random();
        User Amit = User.builder()
                .userId(String.valueOf(random.nextInt()))
                .userName("Amit")
                .emailId("XXXXXXXXXXXXXX")
                .mobileNumber("7724249273")
                .balance(new Balance())
                .build();

        User Vivek = User.builder()
                .userId(String.valueOf(random.nextInt()))
                .userName("Vivek")
                .emailId("XXXXXXXXXXXXXX")
                .mobileNumber("7724249273")
                .balance(new Balance())
                .build();
        User Jatin = User.builder()
                .userId(String.valueOf(random.nextInt()))
                .userName("Jatin")
                .emailId("XXXXXXXXXXXXXX")
                .mobileNumber("7724249343")
                .balance(new Balance())
                .build();
        AmitsPartyGroup.addMember(Amit);
        AmitsPartyGroup.addMember(Vivek);
        AmitsPartyGroup.addMember(Jatin);
        Map<User, Integer> splitWith = new HashMap<>();
        splitWith.put(Vivek, 20); // Vivek gets 20%
        splitWith.put(Jatin, 80);
        Expense expense = Expense.builder()
                .expenseId(String.valueOf(random.nextInt()))
                .date("22/09/2004")
                .description("breakfast")
                .paidBy(Amit)
                .amount(200.0)
                .splitWith(splitWith)
                .build();
        AmitsPartyGroup.addExpense(expense, SplitType.PERCENTAGE);
        AmitsPartyGroup.showBalanceOfAllMembers();
    }
}
