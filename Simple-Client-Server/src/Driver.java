
public class Driver {

	private int id;

    private String name;

    private int age;

    private boolean isMale;
    
    public Driver(int id, String name,int age, boolean isMale){
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.isMale = isMale;
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

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
}
