import java.util.Arrays;
import java.util.Stack;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		int[] nums = { 2, 6, 8, 5, 4, 3, 8, 5, 3, 6, 8, 4, 6 };
		Test t = new Test();
		t.sortQuick(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
		
		int[] nums2 = { 1, 2, 3, 4};
		t.quanPaiLie(nums2, 0, nums2.length);
	}
	
	public void sortQuick(int[] nums, int start, int end) {
		int left = start;
		int right = end;
		int middleValue = nums[start + (end - start)/2];
		while(left < right) {
			while(middleValue > nums[left]) {
				left++;
			}
			while(middleValue < nums[right]) {
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
	
	// 数组全排列
	public void quanPaiLie(int[] nums, int start, int len) {
		if(start == (len - 1)) {
			System.out.println(Arrays.toString(nums));
		}
		for(int i = start; i < len; i++) {
			swap(nums, start, i);
			quanPaiLie(nums, start+1, len);
			swap(nums, start, i);
		}
	}
	public void swap(int[] nums, int i, int j) {
		int tem = nums[i];
		nums[i] = nums[j];
		nums[j] = tem;
	}
	
	class TreeNode {
		TreeNode left;
		TreeNode right;
	}
	
	public void DLR(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(!stack.isEmpty() && node != null) {
			while(node != null) {
				System.out.println(node);
				stack.push(node);
				node = node.left;
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}

}
