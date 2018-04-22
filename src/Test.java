//1 10 11 100 101 110 111 110
public class Test {
	public static final int a = 0;
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
	}
	
	
	
}
class Test1 {
	public static int a = 9;
}
class Person {
	int id;
	public Person(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(null == obj || getClass() != obj.getClass())
			return false;
		
		Person p = (Person)obj;
		return this.id == p.id;
	}
}
	

