package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {

    private int studentId;
    private String name;
    private String major;
    private int grade;

    //Constructor Overloading(생성자 중복정의)
    public Student(int studentId, String name, String major) {
        setStudentId(studentId);
        setName(name);
        setMajor(major);
    }

    //studentId 필드에 대한 getter, setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //name 필드에 대한 getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //major 필드에 대한 getter, setter
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    //grade 필드에 대한 getter, setter
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws InvalidGradeException {
        //학년이 4학년을 초과할 경우 -> 예외처리
        if(grade > 4) {
            System.out.print(grade + "학년으로 변경\n");
            String errMessage = "학년은 1~4 사이여야 합니다.";
            throw new InvalidGradeException(errMessage);
        }
        this.grade = grade;
    }
}