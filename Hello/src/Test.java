import java.util.HashMap;
import java.util.Map;

//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		Map<Person,String> map = new HashMap<>();
		Person p1 = new Person(1);
		map.put(p1, "p1");
		System.out.println(map.get(new Person(1)));
		System.out.println(5);
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
	

