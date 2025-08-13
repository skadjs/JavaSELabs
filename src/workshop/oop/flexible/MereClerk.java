package workshop.oop.flexible;

//평사원 클래스
public class MereClerk extends Employee {
	
	String name;
	double salary;
	 
	public MereClerk (String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	 
	public void manageSalary(double rate) {
		salary = salary+ salary*(rate/100);
	}
}