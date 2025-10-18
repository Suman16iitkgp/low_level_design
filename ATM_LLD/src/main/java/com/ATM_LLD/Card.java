package com.ATM_LLD;

public class Card {
    private int cardNumber;
    private int pin;
    private int cvv;
    private int expiryDate;

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    private UserBankAccount userBankAccount;

    public boolean isPinCorrect(int pin) {
        return pin == this.pin;
    }

    public int getBalance() {
        return userBankAccount.getBalance();
    }

    public void deductBalance(int amount) {
        userBankAccount.withdrawBalance(amount);
    }



}
