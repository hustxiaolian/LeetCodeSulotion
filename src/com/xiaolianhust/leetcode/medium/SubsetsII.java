package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetsWithDup(new int[] {1,2,2}));
	}
	
	/**
	 * 第一种思路：
	 * 核心思路还是subset中for+递归那套。关键是如何判断重复，即排序后，当前轮次(当前curr位置)不能中不要和
	 * 上轮相同。
	 * 
	 * 具体思路：
	 * 1. 初始化变量，处理特殊情况。并且吧空集添加到结果中
	 * 2. 进入递归。边递归边添加结果。
	 * 
	 * test1:5ms, beats 71.73%ε=ε=ε=┏(゜ロ゜;)┛
	 * 还行，我的例程思路非常简单。
	 * 
	 * 改进：使用ArrayList可以改进addOneAns这个步骤，因为可以直接把cache把构造参数传入。
	 * 虽然速度上没有提升，但是更加精简。
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        result.add(new ArrayList<>());
        if(n == 0) return result;
        Arrays.sort(nums);
        ArrayList<Integer> cache = new ArrayList<>();
        subsetRecursion(result,cache, nums, 0, n, 0);
        return result;
    }
	/**
	 * 核心思想：判断当前位置上是否和上轮的数字相同，相同那么它就是重复的，没有意义，直接跳过。
	 * @param result
	 * @param cache
	 * @param nums 
	 * @param i
	 * @param n
	 * @param j
	 */
	private static void subsetRecursion(List<List<Integer>> result, ArrayList<Integer> cache, int[] nums, int startIndex, int n, int curr) {
		for(int i = startIndex;i < n;++i) {
			if(i > startIndex && nums[i] == nums[i - 1])//加上startindex就是说，你首轮可以和前面相同。
				continue;
			cache.add(nums[i]);
			result.add(new ArrayList<>(cache));
			subsetRecursion(result, cache, nums, i + 1, n, curr + 1);
			cache.remove(curr);
		}
	}
	

}
