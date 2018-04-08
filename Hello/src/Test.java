//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		System.out.println(findIt(1000000000));
	}
	
	// 找出大于n的最小的2的幂
	public static int findIt2(int n) {
		int i = 1;
		while(i < n) {
			i <<= 1;
		}
		return i;
	}
	
	// 找出大于n的最小的2的幂
	public static int findIt(int n) {
		while(!isTwo(n)) {
			n++;
		}
		return n;
	}
	
	// 判断是否是2的幂
	public static boolean isTwo(int n) {
		while(n > 1) {
			if(n%2 == 1)
				return false;
			n /= 2;
		}
		return true;
	}
}
