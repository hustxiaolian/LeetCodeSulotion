package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3, 9));
	}
	
	/**
	 * 思路：
	 * 一道非常经典的回溯法的题目。
	 * 即肯定用递归来做，涉及到回溯，必然有一个cache。
	 * 基准情况就是达到条件后，将cache添加到result中。
	 * 
	 * 为了避免重复，设置start，让结果集合中保证排序性，避免重复，同时可以保证每个数字只用了一次。
	 * 设置curr，来计算递归层数，这里迭代层数就代表中cache中有了几个数，curr==k就是边界。
	 * 设置tempSum，来保留cache中当前的和值，用来判断边界时是否符合条件，同时，可以利用它来避免不必要的计算。
	 * 
	 * 回溯法的思想，就是尝试添加-》添加后结果再处理或者判断-》完成后删除。
	 * 在本题中，思想的体现就在于cache下先添加后判断。
	 * @param k
	 * @param n
	 * @return
	 */
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        helper(result, cache, k, n, 0, 1, 0);
        return result;
    }

	private static void helper(List<List<Integer>> result, List<Integer> cache, int k, int target, int curr, int start, int tempSum) {
		if(curr == k) {
			if(tempSum == target) {
				List<Integer> oneAns = new ArrayList<>(cache);
				result.add(oneAns);
			}
			return;
		}
		
		for(int i = start;i < 10;++i) {
			if(tempSum + i > target)
				break;
			cache.add(i);
			helper(result, cache, k, target, curr + 1, i + 1, tempSum + i);
			cache.remove(cache.size() - 1);
		}
	}
}
