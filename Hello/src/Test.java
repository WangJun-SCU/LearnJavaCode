//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		System.out.println("123".substring(1,2));
	}
	
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
	

