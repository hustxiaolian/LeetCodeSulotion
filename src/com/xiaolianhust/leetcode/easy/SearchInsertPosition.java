package com.xiaolianhust.leetcode.easy;


/**
 * 
 * @author 25040
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路肯定是二分查找,毫无疑问，但是也必须对原有的二分查找对出一定的改进。
	 * 二分法的例程最好能够默写下来。
	 * 
	 * 这里对二分法的改进，就是加了前面两个特殊情况判断。
	 * 同时在retur中直接返回left，如果数组中有该元素那么直接return mid就行了。
	 * 考虑数组中没有该元素的情况，那么最后几轮迭代就是
	 * 1. nums[left] < target < nums[right];left + 1 = right;假设left = n- 1 ,right = n;
	 * 2. left = n, right = n;
	 * 3. right = n-1 ,left = n;迭代终止。而这种情况分分析对于所有的nums数组中没有target的所有情况都适用。
	 * 
	 * test1:5ms, beats(100%,ε=ε=ε=┏(゜ロ゜;)┛)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        
        //处理特殊情况，直接返回
        if(target <= nums[0]) return 0;
        if(target > nums[right]) return right + 1;
        
    	while(left <= right) {
    		mid = (left + right) / 2;
    		if(target > nums[mid])
    			left = mid + 1;
    		else if(target < nums[mid])
    			right = mid - 1;
    		else 
    			return mid;
    	}
    	
    	
    	return left;
    }
}
