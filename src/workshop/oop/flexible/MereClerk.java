package workshop.oop.flexible;

// 평사원 클래스
public class MereClerk extends Employee {
	 
	public MereClerk (String name, double salary) {
		// this.name = name;
		// this.salary = salary;
		super(name, salary);
	}
	
	// 오버라이딩 규칙: 부모가 상속해 준 메서드의 Signature(메서드 선언부)가 반드시 같아야 한다.
	@Override
	public void manageSalary(double rate) {
		salary = salary+ salary*(rate/100);
	}
}