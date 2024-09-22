package com.src.splitwise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Balance {
    private double positiveBalance;
    private double negativeBalance;
    private double netBalance;
    private final HashMap<User,Double> amountLoanedPeopleDetails;
    private final HashMap<User,Double> amountToGivePeopleDetails;

    public Balance(){
        amountLoanedPeopleDetails = new HashMap<>() ;
        amountToGivePeopleDetails = new HashMap<>() ;
        positiveBalance = 0.0;
        negativeBalance = 0.0;
        netBalance = 0.0;
    }

    private void calculateNetAmount() {
        netBalance = positiveBalance - negativeBalance;
    }

    public void addToPositiveBalance(User user,double amount) {
        positiveBalance += amount;
        amountLoanedPeopleDetails.compute(user,(k,v) -> (v==null ? amount : v+amount));
        calculateNetAmount();
    }

    public void addToNegativeBalance(User user,double amount) {
        negativeBalance += amount;
        amountToGivePeopleDetails.compute(user, (k, v) -> (v==null ? amount : v+amount));
        calculateNetAmount();
    }

    public void settlePositiveBalance(User user, double amount) {
        positiveBalance -= amount;
        amountLoanedPeopleDetails.put(user, amountLoanedPeopleDetails.get(user) - amount);
        calculateNetAmount();
    }

    public void settleNegativeBalance(User user, double amount) {
        negativeBalance -= amount;
        amountToGivePeopleDetails.put(user, amountToGivePeopleDetails.get(user) - amount);
        calculateNetAmount();
    }

    public void updateAmountLoanedPeopleDetails(User user,double amount){
        amountLoanedPeopleDetails.put(user, amountLoanedPeopleDetails.get(user) - amount);
    }

    public void displayBalance() {
        System.out.println("Positive Balance: " + positiveBalance);
        System.out.println("Negative Balance: " + negativeBalance);
        System.out.println("Net Balance: " + netBalance);
        for(Map.Entry<User,Double> entry : amountLoanedPeopleDetails.entrySet()) {
            System.out.println(entry.getKey().getUserName() + " owes " + entry.getValue());
        }
        for(Map.Entry<User,Double> entry : amountToGivePeopleDetails.entrySet()) {
            System.out.println(entry.getKey().getUserName() + " owes " + entry.getValue());
        }
    }

}
