package com.xiaolianhust.leetcode.review;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 1. 使用一个hashset来记录之前出现的所有数字。
	 * 2. 每次都判断是否hashset.contain(target-nums[i])
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i) {
        	if(map.containsKey(target - nums[i]))
        		return new int[] {map.get(target - nums[i]), i};
        	map.put(nums[i], i);
        }
        return null;//这里相当于意思下。
    }
}
