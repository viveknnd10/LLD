package com.src.splitwise.model;

public class Settle {
    private final Double amount;
    private final User paidTo;
    private final User paidBy;
    public Settle(Double amount, User paidTo, User paidBy) {
        this.amount = amount;
        this.paidTo = paidTo;
        this.paidBy = paidBy;
    }
    public void settleNegativeBalance(){
        paidBy.getBalance().getAmountToGivePeopleDetails().put(paidTo, paidBy.getBalance().getAmountToGivePeopleDetails().get(paidTo) - amount);
        paidBy.getBalance().settleNegativeBalance(paidTo,amount);
        paidTo.getBalance().updateAmountLoanedPeopleDetails(paidBy, amount);
        paidTo.getBalance().settlePositiveBalance(paidBy,amount);
    }
}
