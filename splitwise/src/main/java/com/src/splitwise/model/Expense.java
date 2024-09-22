package com.src.splitwise.model;

import lombok.Builder;
import lombok.Getter;
import java.util.Map;
import java.util.Optional;

@Getter
@Builder
public class Expense {
    private String expenseId;
    private String groupId;
    private User paidBy;
    private double amount;
    private String description;
    private String date;
    private Map<User,Integer> splitWith;
}
