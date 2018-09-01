package com.xiaolianhust.leetcode.easy;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLengthOfLCIS(new int[] {2,2,2,2,2,3,4}));
	}
	
	/**
	 * 思路：
	 * 就是一个记录上升沿的过程。
	 * 
	 * test1: 3ms, beats 98.40%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int result = 0, count = 1, i = 1;
        while(i < n) {
        	while(i < n && nums[i] > nums[i - 1]) {
        		++count;
        		++i;
        	}
        	result = Math.max(result, count);
        	while(i < n && nums[i] <= nums[i - 1])
        		i++;
        	count = 1;
        }
        return result;
    }
}
