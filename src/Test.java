import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		int[] nums = {2,6,8,5,4,3,8,5,3,6,8,4,6};
		Test t = new Test();
		t.sortQuick(nums);
		System.out.println(Arrays.toString(nums));
	}
	//快速排序
	public void sortQuick(int[] nums) {
		sortQuickHelper(nums, 0, nums.length - 1);
	}
	public void sortQuickHelper(int[] nums, int start, int end) {
		int left = start;
		int right = end;
		int middle = start + (end - start)/2;
		while(left < right) {
			while(nums[left] < nums[middle]) {
				left++;
			}
			while(nums[right] > nums[middle]) {
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
		if(left < end) sortQuickHelper(nums, left, end);
		if(right > start) sortQuickHelper(nums, start, right);
	}
}
