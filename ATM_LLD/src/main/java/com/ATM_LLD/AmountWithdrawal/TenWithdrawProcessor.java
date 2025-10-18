package com.ATM_LLD.AmountWithdrawal;

import com.ATM_LLD.ATM;

public class TenWithdrawProcessor extends CashWithdrawProcessor {
    public TenWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void withdraw(ATM atm, int amount){
        int notes = Math.min(amount/10, atm.getHundredNotes());

        int balance = amount - notes * 10;

        if( balance > 0 ){
            System.out.println("Something went wrong");
        }

    }
}
