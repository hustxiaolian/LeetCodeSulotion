package com.xiaolianhust.leetcode.review;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 2));
	}
	
	/**
	 * 思路：
	 * 二分搜索法。不对，这就是原本的二分搜索法。直接使用。
	 * 妙啊，不仅仅可以用来寻找它是否存在于这个数组，而且输出了如果这个val要插入，就插入在这个位置。
	 * test1: 3ms, beats 66.14% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(target < nums[mid]) {
        		right = mid - 1;
        	} else if (target > nums[mid]) {
        		left = mid + 1;
        	} else {
        		return mid;
        	}
        }
        return left;
    }
}
