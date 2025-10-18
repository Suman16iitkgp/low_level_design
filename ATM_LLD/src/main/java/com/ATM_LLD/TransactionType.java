package com.ATM_LLD;

public enum TransactionType {
    CASH_WITHDRAW,
    BALANCE_CHECK;

    public static void showAllTransactions() {
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println(transactionType.name());
        }
    }
}
