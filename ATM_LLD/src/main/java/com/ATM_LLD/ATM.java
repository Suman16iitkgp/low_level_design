package com.ATM_LLD;

import com.ATM_LLD.ATMStates.ATMState;
import com.ATM_LLD.ATMStates.IdleState;

public class ATM {
    private static ATM atm;
    private int atmId;
    private ATMState atmState;
    private int atmBalance;
    private int hundredNotes;
    private int tenNotes;
    private int fiftyNotes;

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public int getAtmId() {
        return atmId;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public static ATM getAtm() {
        if(atm == null){
            atm = new ATM();
        }

        atm.setState(new IdleState());

        return atm;
    }

    private ATM(){
    }



    public void setState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getATMBAlance() {
        return atmBalance;
    }

    public void deductATMBalance(int withdrawAmount) {
        this.atmBalance -= withdrawAmount;
    }

    public int getHundredNotes() {
        return this.hundredNotes;
    }

    public void deductHundredNotes(int count) {
        hundredNotes -= count;
    }

    public int getTenNotes() {
        return tenNotes;
    }

    public void deductTenNotes(int count) {
        this.tenNotes -= count;
    }

    public int getFiftyNotes() {
        return fiftyNotes;
    }

    public void deductFiftyNotes(int count) {
        this.fiftyNotes -= count;
    }
}
