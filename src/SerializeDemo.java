import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

	public static void main(String[] args) {
		Employee em = new Employee();
		em.name = "wangjun";
		em.age = 24;
		em.ssh = 123456;
		try {
			FileOutputStream fo = new FileOutputStream("tem.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(em);
			oo.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fi = new FileInputStream("tem.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Employee e2 = (Employee) oi.readObject();
			oi.close();
			fi.close();
			System.out.println(e2.name);
			System.out.println(e2.age);
			System.out.println(e2.ssh);
			e2.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class Employee implements Serializable{
		String name;
		int age;
		transient int ssh;
		public void test() {
			System.out.println("this is test method!");
		}
	}

}
