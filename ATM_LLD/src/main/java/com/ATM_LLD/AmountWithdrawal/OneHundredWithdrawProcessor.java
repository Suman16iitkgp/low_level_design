package com.ATM_LLD.AmountWithdrawal;

import com.ATM_LLD.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void withdraw(ATM atm, int amount){
        int notes = Math.min(amount/100, atm.getHundredNotes());

        int balance = amount - notes * 100;

        if( balance > 0 ){
            super.withdraw(atm, balance);
        }

    }
}
