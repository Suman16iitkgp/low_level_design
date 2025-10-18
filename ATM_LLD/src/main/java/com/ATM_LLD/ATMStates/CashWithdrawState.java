package com.ATM_LLD.ATMStates;

import com.ATM_LLD.ATM;
import com.ATM_LLD.AmountWithdrawal.CashWithdrawProcessor;
import com.ATM_LLD.AmountWithdrawal.FiftyWithdrawProcessor;
import com.ATM_LLD.AmountWithdrawal.OneHundredWithdrawProcessor;
import com.ATM_LLD.AmountWithdrawal.TenWithdrawProcessor;
import com.ATM_LLD.Card;

public class CashWithdrawState extends ATMState {

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        if(atm.getATMBAlance() < withdrawAmount ){
            System.out.println("Not enough balance in the ATM Machine");
            exit(atm);
        }
        else if( card.getBalance() < withdrawAmount ){
            System.out.println("Not enough balance in your Bank Account");
            exit(atm);
        }else{
            card.deductBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);

            CashWithdrawProcessor cashWithdrawProcessor = new OneHundredWithdrawProcessor( new FiftyWithdrawProcessor( new TenWithdrawProcessor(null ) ) );


        }
    }
}
