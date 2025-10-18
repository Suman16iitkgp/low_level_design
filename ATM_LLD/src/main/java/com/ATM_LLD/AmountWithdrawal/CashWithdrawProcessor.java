package com.ATM_LLD.AmountWithdrawal;

import com.ATM_LLD.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextProcessor;
    public CashWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdraw(ATM atm, int amount){
        if(nextProcessor != null){
            nextProcessor.withdraw(atm, amount);
        }
    }
}
