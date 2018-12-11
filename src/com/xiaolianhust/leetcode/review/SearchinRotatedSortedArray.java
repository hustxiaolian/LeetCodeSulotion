package com.xiaolianhust.leetcode.review;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 1. 首先找到旋转点。由于数组旋转了，那么数组的最大值和最小值是相邻的。
	 * 		使用双指针逼近，让他们逐渐向中间逼近。由于特殊的元素排列情况，+我们的目的，因此，当target>mid,left=mid + 1, 否者right = mid
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if(right < 1) return -1;
		if(nums[left] > nums[right]) {
			int rightVal = nums[right];
			while(left < right) {
				int mid = (left + right) / 2;
				if(rightVal < nums[mid])
					right = mid;
				else
					left = mid + 1;
			}
			if(target >= nums[0]) {
				right = left - 1;
				left = 0;
			} else {
				right = nums.length - 1;
			}
		}
		while(left <= right) {
			int mid = (left + right) / 2;
			if(target < nums[mid])
				right = mid - 1;
			else if (target > nums[mid])
				left = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
