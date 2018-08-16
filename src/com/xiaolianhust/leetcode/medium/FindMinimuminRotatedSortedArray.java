package com.xiaolianhust.leetcode.medium;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
	}
	
	/**
	 * 思路:
	 * 毋庸置疑，二分法。
	 * 这种旋转以后的数组有一个奇妙的性质，那就是在旋转点附近，存在着最大的相邻差值。
	 * 因此在二分搜索的过程中，应该是往更大左右差值的地方去。
	 * 这种只针对已经旋转的方法有效。
	 * 
	 * bug1:{1,2}这种输入，也就是说它没旋转，判断有没有旋转的方法就是直接看第一个元素和最后一个元素的大小。
	 * 因此，加上一个判断即可。
	 * 
	 * 看了下discuss，果然是八仙过海各显神通啊。
	 * 
	 * 在排序数组中，左边永远比右边小，但是旋转后，我们可以根据这种断层来检测旋转点。
	 * discuss中利用以下几点：
	 * 1. 除法具有潜在的向左移动。
	 * 2. 旋转排序后，可以根据左边或者右边这种基准来判断到底在上面还是下面。
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		if(nums[left] < nums[right]) return nums[left];
		while(left + 1< right) {
			int mid = (left + right) / 2;
			int midVal = nums[mid];
			if(Math.abs(midVal - nums[left]) > Math.abs(midVal - nums[right]))
				right = mid;
			else
				left = mid;
		}
		return nums[right];
    }
	
	public static int findMin2(int[] nums) {
		int left = 0, right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] > nums[right]) 
				left = mid + 1;
			else
				right = mid;
		}
		return nums[left];
	}
}
