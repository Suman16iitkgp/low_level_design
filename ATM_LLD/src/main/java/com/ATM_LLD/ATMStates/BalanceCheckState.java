package com.ATM_LLD.ATMStates;

import com.ATM_LLD.ATM;
import com.ATM_LLD.Card;

public class BalanceCheckState extends ATMState {
    public BalanceCheckState() {
        System.out.println("Showing Balance");
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is " + card.getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setState(new IdleState());
    }

    public void returnCard(){
        System.out.println("Returning Card");
    }
}
