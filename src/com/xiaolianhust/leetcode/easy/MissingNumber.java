package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missingNumber3(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	
	/**
	 * 思路：
	 * 第一种简单粗暴的方法。
	 * 直接排序判断就完事了。
	 * 
	 * test1: 10ms, beats 10.93%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
        for(int i = 0;i < n;++i)
        	if(nums[i] != i)
        		return i;
        return n;
    }
	
	/**
	 * 第二种思路：
	 * 使用hashset来存储。然后遍历检查。
	 * @param nums
	 * @return
	 */
	public static int missingNumber2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int num : nums)
			set.add(num);
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			if(nums[i] != i)
				return i;
		}
		return n;
	}
	
	/**
	 * 第三种思路：
	 * 使用bit操作。使用xor的性质来完成。
	 * 
	 * test2:1ms, beat 52.54% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static int missingNumber3(int[] nums) {
		int missNum = nums.length;
		int n = missNum;
		for(int i = 0;i < n; ++i)
			missNum ^= (i ^ nums[i]);
		return missNum;
	}
}
