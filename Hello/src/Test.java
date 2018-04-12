import java.util.Arrays;

//1 10 11 100 101 110 111 110
public class Test {
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,1,2,3};
		sortBuddle(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sortBuddle(int[] arr){
		
		for(int i = 0; i < arr.length; i++){
			boolean tag = false;
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
					tag = true;
				}
			}
			if(!tag)
				break;
		}
	}
}

	

