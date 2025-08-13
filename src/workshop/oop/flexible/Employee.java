package workshop.oop.flexible;

// 추상클래스는 객체를 생성할 수 없다.
// Employee e = new Employee(); (x)
// Employee e = new Manager(); (o)
// 추상메서드를 하나 이상 가지고 있으면 -> 무조건 추상클래스가 됨.
// Super 클래스의 메서드가 추상메서드 -> Sub 클래스에서 그 추상메서드를 ***반드시 오버라이딩*** 해야 함.
public abstract class Employee extends Object {
	
	private String name;
	protected double salary;
    
    public Employee() {
    }
    
    public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
    
    // Concrete 메서드: 바디가 있는 메서드
	public String getName() {
        return this.name;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    // Abstracta 메서드: 바디가 없는 메서드
    public abstract void manageSalary(double rate);
}
