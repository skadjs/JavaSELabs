package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	
	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}

	public Cat() {
		//super(4);
		this("");
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
}
