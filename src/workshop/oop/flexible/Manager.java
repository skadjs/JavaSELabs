package workshop.oop.flexible;

// 관리자 클래스
public class Manager extends Employee {
	
	private String dept; // 부서 정보
    
    public Manager (String name, double salary) {
        // this.name = name;
        // this.salary = salary;
    	super(name, salary);
    }
    
    public Manager(String name, double salary, String dept) {
    	this(name, salary); // 위에 있는 Manager 생성자 호출
    	this.dept = dept;
    }
    
    // 부서 정보 반환하는 getter
    public String getDept() {
    	return dept;
    }
    
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
        salary += 20; // 20만 원을 추가로 받는다
    }
}