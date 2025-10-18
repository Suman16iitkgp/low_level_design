package com.ATM_LLD.AmountWithdrawal;

import com.ATM_LLD.ATM;

public class FiftyWithdrawProcessor extends CashWithdrawProcessor {

    public FiftyWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void withdraw(ATM atm, int amount){
        int notes = Math.min(amount/50, atm.getFiftyNotes());

        int balance = amount - notes * 50;

        if( balance > 0 ){
            super.withdraw(atm, balance);
        }

    }
}
