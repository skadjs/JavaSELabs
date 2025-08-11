package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    // 이자 적용
    public void applyInterest() {
        double interest = balance * interestRate / 100.0;
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n", interest, this.balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + this.balance);
        }
        this.balance -= amount;
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원\n", amount, this.balance);
    }
    
    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%", 
            accountNumber, ownerName, balance, interestRate);
    }
}