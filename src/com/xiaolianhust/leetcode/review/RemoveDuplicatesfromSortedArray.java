package com.xiaolianhust.leetcode.review;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	
	/**
	 * 思路：
	 * 双指针来完成整个遍历过程。
	 * 指针i遍历数组中的每个元素，指针j仅仅在nums[i] > nums[j]的时候才移动并且赋值。
	 * 
	 * test 1: 7ms, beats 80.96%
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int j = 0;
		for(int i = 1;i < n; ++i) {
			if(nums[i] > nums[j])
				nums[++j] = nums[i];
		}
		return j + 1;
	}
}
