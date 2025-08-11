package mylab.bank.exception;

// 잔액 부족 예외의 한 종류로 간주 -> 상속
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}