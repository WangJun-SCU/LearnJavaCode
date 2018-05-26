import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		int[] nums = {2,6,8,5,4,3,8,5,3,6,8,4,6};
		Test t = new Test();
		t.sortQuick(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
		
		int[] nums2 = {1,2,3,4};
		t.printAllNums(nums2, 0, nums2.length);
	}
	
	
	//全排列
	public void printAllNums(int[] nums, int start, int len) {
		if(start == (len - 1)) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int i = start; i < len; i++) {
			swap(nums, i ,start);
			printAllNums(nums, start + 1, len);
			swap(nums, i ,start);
		}
	}
	public void swap(int[] nums, int i, int j) {
		int tem = nums[i];
		nums[i] = nums[j];
		nums[j] = tem;
	}
	
	//快速排序
	public void sortQuick(int[] nums) {
		sortQuick(nums, 0, nums.length - 1);
	}
	public void sortQuick(int[] nums, int start, int end) {
		int left = start;
		int right = end;
		int middle = start + (end - start)/2;
		while(left < right) {
			while(nums[middle] > nums[left]) {
				left++;
			}
			while(nums[middle] < nums[right]) {
				right--;
			}
			if(left < right) {
				int tem = nums[left];
				nums[left] = nums[right];
				nums[right] = tem;
				left++;
				right--;
			}
		}
		if(left == right) {
			left++;
		}
		if(left < end) {
			sortQuick(nums, left, end);
		}
		if(right > start) {
			sortQuick(nums, start, right);
		}
	}
}
