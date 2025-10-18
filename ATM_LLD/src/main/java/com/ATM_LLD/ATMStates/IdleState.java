package com.ATM_LLD.ATMStates;

import com.ATM_LLD.ATM;
import com.ATM_LLD.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Inserting Card");
        atm.setState( new HashCardState() );
    }

}
