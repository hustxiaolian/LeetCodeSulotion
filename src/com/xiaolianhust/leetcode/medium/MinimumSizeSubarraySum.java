package com.xiaolianhust.leetcode.medium;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}
	
	/**
	 * 第一种思路：
	 * 简单，粗暴的方法。
	 * 首先定义一个长度为1的窗口，然后从左至右计算窗口内和值，符合target则直接返回。
	 * 接下俩将依次将窗口长度变为2，3，4....
	 * 慢，大量的重复计算。
	 * 
	 * 改进自粗暴思路，我们定义一个长度可变的滑动窗口,以两个指针指向左右两端表明。
	 * 窗口内和值大了就left++，和值小了就right++，等于就判断记录。
	 * 
	 * test1:4ms, beats 20.50%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 改进思路：
	 * 其实只有在它变向的时候，才需要记录，也就说它节省了Math.min的操作次数。
	 * 晚饭回来后，看看。
	 * 
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int result = n + 1;
        int left = 0, right = 0, windowSum = 0;
        //窗口滑动
        while(right < n) {
        	if(left == right || windowSum < s) {
        		windowSum += nums[right++];
        	}
        	else {
        		result = Math.min(result, right - left);
        		if(windowSum > s)
        			windowSum -= nums[left++];
        		else
        			windowSum += nums[right++];
        	}
        }
        //解决到了末尾的问题,判断末尾是否还有需要可能的子数组。
        if(windowSum >= s) {
        	while(left < n) {
            	if(windowSum >= s) 
            		result = Math.min(result, right - left);
            	else
            		break;
        		windowSum -= nums[left++];
            }
        }
        
        //判断是否有一个合法的子数组。
        if(result == n + 1)
        	return 0;
        return result;
    }
}
