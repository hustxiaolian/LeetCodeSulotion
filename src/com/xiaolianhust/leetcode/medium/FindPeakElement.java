package com.xiaolianhust.leetcode.medium;

public class FindPeakElement {
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {Integer.MIN_VALUE}));
	}
	
	/***
	 * 思路：
	 * 题意：相邻的两个数字必定不相同，然后nums[-1]以及nums[n]都是负无穷大。
	 * 同时，题目要求必须是log的时间复杂度。
	 * 
	 * 想到的第一个思路：
	 * 1. 二分法取中间的值，如果该值周围的趋势是上坡状态，即nums[i-1] <nums[i] < nums[i+1]
	 * 		那么从逻辑上来讲，为了寻找山峰，应该往上坡方向上走,往右边迭代
	 * 2. 同理，如果该索引周围的趋势是下坡状态，即nums[i-1]>nums[i]>nums[i+1]，往左边迭代。
	 * 3. 如果nums[i]刚好满足peak，即nums[i-1]<nums[i] && nums[i]>nums[i+1]
	 * 4. 同时还有刚好在波谷的情况，那么任选一个方向进行迭代。
	 * 
	 * test1:3ms, beats 99.86%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param nums
	 * @return
	 */
	public static int findPeakElement(int[] nums) {
        int result = -1;
        int n = nums.length, left = 0, right = n - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	long midLeft = mid - 1< 0?Long.MIN_VALUE : nums[mid - 1];//这里为了防止有人恶意输入Integer.MIN_VALUE,导致程序逻辑问题，直接使用long
        	long midRight = mid + 1>= n?Long.MIN_VALUE : nums[mid + 1];
        	int midVal = nums[mid];
        	
        	if(midLeft < midVal) {
        		if(midVal < midRight) //上坡
        			left = mid + 1;
        		else //峰值
        			return mid;
        	}
        	else //波谷和下坡合并在一种情况
        		right = mid - 1;
        }
        return result;
    }
}
