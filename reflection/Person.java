package reflection;

public class Person implements ReadInterface{
     private int id;
     private String name;
     public int age;
     
	public Person() {
	}
	
	public Person(int id) {
		super();
		this.id = id;
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    public static void update(){
    	
    }
	@Override
	public void read() {
		
	}
     
}
