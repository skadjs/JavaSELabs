package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000, 3.0);
        bank.createCheckingAccount("김철수", 20000, 5000);
        bank.createSavingsAccount("이영희", 30000, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================\n");
        
        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            Account foundAccount = bank.findAccount("AC1000");
            if (foundAccount instanceof SavingsAccount) {
                ((SavingsAccount) foundAccount).applyInterest();
            }
        } catch (AccountNotFoundException e) {
             System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // 예외 처리 테스트
        try {
            System.out.println("체킹 계좌 한도 초과 출금 시도...");
            bank.withdraw("AC1001", 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            System.out.println("저축 계좌 잔액 부족 출금 시도...");
            bank.withdraw("AC1000", 20000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
            System.out.println("존재하지 않는 계좌 조회 시도...");
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}