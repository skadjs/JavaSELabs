package workshop.oop.flexible;

public class FlexibleCompanyDemo {
	
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("철수", 100);
        MereClerk mereClerk2 = new MereClerk("영희", 100);
        Manager manager = new Manager("홍길동", 200);
        
        // 자식 mgr = 자식 vs. 부모 mgr = 자식(다형성)
        // 자식 mgr = 자식
        Manager hrMgr = new Manager("둘리", 200, "HR"); 
        System.out.println(hrMgr.getName());
        System.out.println(hrMgr.getSalary());
        System.out.println(hrMgr.getDept());
        
        // 부모 mgr = 자식(다형성)
        // 다형성(Polymorphism) = Poly(다양한) + Morphism(변신, 변형)
        Employee itMgr = new Manager("길동", 250, "IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        
        // Manager(자식)가 가진 getDept() 메서드 호출하기
        Manager itMgr2 = (Manager) itMgr; // Employee 타입인 itMgr을 Manager로 casting
        System.out.println(itMgr2.getDept());
       
        // Heterogeneous Collection => Employee 타입의 배열 선언
        // emps 변수 -> Employee[] 타입, emps[0] -> Employee 타입
        Employee[] emps = new Employee[4];
        // 하나의 타입(Employee)에 여러 자식 타입(Manager, MereClerk)을 담는다 => 일괄처리 가능
        emps[0] = new Manager("길동", 250, "IT");
        emps[1] = new MereClerk("철수", 100);
        emps[2] = new MereClerk("영희", 100);
        emps[3] = new Manager("둘리", 200, "HR");
        
        for (Employee emp : emps) {
        	System.out.println("현재 월급입니다.");
        	System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만 원입니다.");
        	emp.manageSalary(10);
        	
        }
        
        for (Employee emp : emps) {
        	System.out.println("올린 후의 월급입니다.");
        	System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만 원입니다.");
        }
    }
}
