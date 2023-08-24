package immutableclass;

//Make class as final
//Make variables as private
//Make variable as final
//No setter method
//Make Deep copy for Object 

final class ImmutableClass {
	private final int id;
	private final String name;
	private final Engine engine;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ImmutableClass(int id, String name, Engine engine) {
		this.id = id;
		this.name = name;
//		this.engine=engine;
		Engine newEngine = new Engine(engine.speed);
		this.engine = newEngine;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Engine e = new Engine(20);
		ImmutableClass a = new ImmutableClass(1, "vishal", e);
		System.out.println(a.getId());
		System.out.println(a.getName());
		System.out.println(a.engine.speed);
		e.speed = 40;
		System.out.println(a.engine.speed);

	}

}
