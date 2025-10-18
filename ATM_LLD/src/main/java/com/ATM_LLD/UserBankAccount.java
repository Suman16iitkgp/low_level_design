package com.ATM_LLD;

public class UserBankAccount {
    private int balance;
    private int accountNumber;


    public int getBalance() {
        return balance;
    }

    public void withdrawBalance(int amount) {
        balance = balance - amount;
    }
}
