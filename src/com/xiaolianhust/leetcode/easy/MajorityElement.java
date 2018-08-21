package com.xiaolianhust.leetcode.easy;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(majorityElement(new int[] {10,9,9,9,10}));
	}
	
	/**
	 * 思路：
	 * 计数方法。首先majar转换成数学概念也就是说这个数字>n / 2
	 * 
	 * test1: 5ms, beats 54.04%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
        int x = nums[0], n = nums.length;
        int count = 1;
        for(int i = 1;i < n;++i) {
        	if(x == nums[i]) {
        		++count;
        	} else {
        		--count;
        		if(count == 0) {
        			x = nums[++i];
        			count = 1;
        		}
        	}
        }
        return x;
    }
	
}
