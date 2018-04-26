//1 10 11 100 101 110 111 110
public class Test {
	public static final int a = 0;
	public static void main(String[] args) {
		//系统默认的类加载器是应用加载器AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
	}
}
	

