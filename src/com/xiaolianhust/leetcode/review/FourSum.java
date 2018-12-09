package com.xiaolianhust.leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FourSum().fourSum(new int[] {1,-2,-5,-4,-3,3,3,5}, -11));
	}
	
	
	/**
	 * 题目意思：
	 * 找到4个数字=target，找出所有的可能性。
	 * 思路：
	 * 0.排序
	 * 1. 最外层两层遍历循环
	 * 2. 内层使用两端到中间的遍历方式，还得使用while来防止重复。
	 * 
	 * 
	 * test1: 67ms, 改进进步的空间主要在于如何避免已知不可能有解的情况
	 * 我以前的思路，包括前排的思路就是：求出max4, max3, max2，依次来判断跳过大量的不必要的判断。
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
    	for(int i = 0;i < n - 3;++i) {
    		if(i != 0 && nums[i] == nums[i - 1]) 
    			continue;
    		for(int j = i + 1;j < n - 2;++j) {
    			if(j != i + 1 && nums[j] == nums[j - 1])
    				continue;
    			int sumij = nums[i] + nums[j];
    			int p = j + 1, q = n - 1;
    			while(p < q) {
    				int sumpq = nums[p] + nums[q];
    				if(sumij + sumpq < target) {
    					++p;
    				} else if (sumij + sumpq > target) {
    					--q;
    				} else {
    					result.add(new ArrayList<>(Arrays.asList(new Integer[] {nums[i], nums[j], nums[p], nums[q]})));
    					++p;--q;
    					while(p < q && nums[p] == nums[p - 1])
    						++p;
    					while(p < q && nums[q] == nums[q + 1])
    						--q;
    				}
    			}
    		}
    	}
        return result;
    }
}
