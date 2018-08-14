package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 直接hashtable来记录，查询即可。
	 * test1:10ms, beats 63.02%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
        	if(set.contains(num))
        		return true;
        	set.add(num);
        }
        return false;
    }
	
	/**
	 * 这个形式，竟然比上面还有快上一倍，果然标准库的排序是经过特殊的优化了。
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0;i < n;++i)
			if(nums[i] == nums[i + 1]) return true;
		return false;
	}
}
