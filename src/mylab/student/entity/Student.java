package mylab.student.entity;

public class Student {
	//Student 클래스를 작성하고, 다음 조건을 만족하도록 캡슐화(Encapsulation)를 적용하시오.
	//학년은 1~4 까지만 허용되며, 범위를 벗어날 경우 오류 메시지를 출력하도록 setGrade() 구현
	private int studentId;
	private String name;
	private String major;
	private int grade;
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
