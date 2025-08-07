package mylab.student.exception;

//사용자정의 Exception
public class InvalidGradeException extends Exception {
	public InvalidGradeException(String errMessage) {
		//부모클래스(Exception)의 생성자 호출
		super(errMessage);
	}
}
