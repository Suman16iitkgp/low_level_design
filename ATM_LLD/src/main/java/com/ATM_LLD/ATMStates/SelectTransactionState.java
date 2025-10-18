package com.ATM_LLD.ATMStates;

import com.ATM_LLD.ATM;
import com.ATM_LLD.Card;
import com.ATM_LLD.TransactionType;

public class SelectTransactionState extends ATMState {

    public SelectTransactionState() {
        System.out.println("Please select Transaction");
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAW :
                atm.setState(new CashWithdrawState() );
                break;
            case BALANCE_CHECK:
                atm.setState(new BalanceCheckState() );
            default:
                System.out.println("Invalid Transaction Type");
                exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setState(new IdleState());
    }

    public void returnCard(){
        System.out.println("Returning Card");
    }

    private void showOperations(){
        System.out.println("Showing Operations");
        TransactionType.showAllTransactions();
    }

}
