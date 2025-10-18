package com.ATM_LLD.ATMStates;

import com.ATM_LLD.ATM;
import com.ATM_LLD.Card;

public class HashCardState extends ATMState {

    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("Pin is entered");
        if( card.isPinCorrect(pin) ){
            atm.setState(new SelectTransactionState());
        }else{
            System.out.println("Pin is incorrect");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
    }

    @Override
    public void returnCard(){
        System.out.println("Please take your card");
    }
}
