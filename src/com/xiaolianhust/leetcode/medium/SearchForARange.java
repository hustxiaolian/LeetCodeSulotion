package com.xiaolianhust.leetcode.medium;

/**
 * 
 * @author 25040
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


 */
public class SearchForARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchRange1(new int[] {8,8}, 8);
	}
	
	/**
	 * 思路：还是使用二分搜索。
	 * 0.初始化变量，处理特殊情况。
	 * 1.首先使用二分搜索尝试找到有无这个数.然后在确定范围。
	 * 2.1 使用最笨的办法先做出来
	 * 2.2 再找到有该元素的情况，再用左右用二分法，确定边界。
	 * 
	 * test1:7ms, beats 100%(ε=ε=ε=┏(゜ロ゜;)┛)不是最佳算法。。。。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] searchRange1(int[] nums, int target) {
    	int[] result = new int[] {-1, -1};
        int left = 0, right = nums.length - 1;
        if(nums.length == 0) return result;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(nums[mid] < target) {
        		left = mid + 1;
        	}
        	else if(target < nums[mid]) {
        		right = mid - 1;
        	}
        	else {
        		left = mid;
        		while(left > 0 && nums[left - 1] == nums[left])
        			left--;
        		right = mid;
        		while(right < nums.length - 1 && nums[right + 1] == nums[right])
        			right++;
        		result[0] = left;
        		result[1] = right;
                return result;
        	}
        }
        return result;
    }

}
