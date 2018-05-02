import java.util.Arrays;

//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		test(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void test(int[] arr) {
		arr = null;
	}
}
