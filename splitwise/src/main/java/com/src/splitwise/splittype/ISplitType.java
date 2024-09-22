package com.src.splitwise.splittype;

import com.src.splitwise.model.Expense;
import com.src.splitwise.model.User;

import java.util.ArrayList;

public interface ISplitType {
    public void calculateAmount(Expense expense, ArrayList<User> members);
}
