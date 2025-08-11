package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 입금
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", amount, this.balance);
        }
    }

    // 출금 (추상 메소드)
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    
    // toString (추상 메소드)
    @Override
    public abstract String toString();

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}