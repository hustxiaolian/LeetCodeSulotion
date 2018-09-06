package com.xiaolianhust.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}
	
	/**
	 * 思路：
	 * 使用map遍历数组，更新元素及其对应索引。
	 * test1:16ms ,beats 31.69%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(map.containsKey(curr) && (i - map.get(curr)) <= k)
        		return true;
        	map.put(nums[i], i);
        }
        return false;
    }
	
	/**
	 * 使用一个固定大小的set，相当于一个长度为k的窗口。
	 * 
	 * test2:11ms, beats 79.63%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		if(k == 0) return false;
		HashSet<Integer> set = new HashSet<>();
		int n = nums.length;
		int i;
		for(i = 0;i < Math.min(k, n);++i) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		for(;i < n;++i) {
			if(set.contains(nums[i]))
				return true;
			set.remove(nums[i - k]);
			set.add(nums[i]);
		}
		return false;
	}
}
