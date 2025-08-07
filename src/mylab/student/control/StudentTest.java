package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		//1. Student 객체 생성 - 오버로딩된 생성자(학번, 이름, 전공 필드 초기화)
		//학번(studentId) 임의
		Student student1 = new Student(1122334455, "김민수", "컴퓨터공학");
		
		//학년 필드에 값 대입 - setter
		try {
			student1.setGrade(3);
			student1.setGrade(5); //5학년으로 변경
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}
}
