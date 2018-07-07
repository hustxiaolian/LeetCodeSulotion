package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new PermutationsII().permuteUnique(new int[] {1,2,1,2}));
		System.out.println(permuteUnique2(new int[] {1,1,2}));
	}
	/**
	 * 思路：
	 * 跟前面拿到{@link Permutation}差不多的思路，但是遇到重复掠过
	 * 
	 * 不行，这个思路非常不好解决重复性的问题。
	 * 明天再来撸。
	 * 
	 * discuss:
	 * 它的idea是，由于数字总量是一定的，相同的数字如果放在同一位置上就毫无意义，直接忽略，然后遍历对该索引
	 * 位置而言所有可能不同的情况。
	 * 厉害！学习了，让我从一个全新的角度认识了排列组合。
	 * 
	 * 再次回顾了PermutationsII，这道经典的我没有相通的问题，这次再次使用了不同的方法来做，
	 * 上次让我知道有重复元素的全排列就是想办法去除掉当前位置上已经出现计算过了的元素，之前通过hashSet完成，
	 * 这次是通过排序后相同的元素放在一起，那么每轮需要判断的东西变成了：这个元素是否已经被用过了，
	 * 其次，如果没有用过，它是否已经和之前的元素相同会造成重复运算，
	 * !used[i-1]这一项的判断就是为了保证是当前轮次的重复，和前面位置的重复是合情合理的。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        permute(result, nums, 0);
        return result;
    }
	
	private void permute(List<List<Integer>> result, int[] nums, int index) {
		if(index == nums.length) {
			List<Integer> onsAns = new ArrayList<>();
			for(int num : nums)
				onsAns.add(num);
			result.add(onsAns);
			return;
		}
		
		HashSet<Integer> appeared = new HashSet<>();
		for(int i = index;i < nums.length; ++i) {
			if(appeared.add(nums[i])) {
				swap(nums, index, i);
				permute(result, nums, index + 1);
				swap(nums, index, i);
			}
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static List<List<Integer>> permuteUnique2(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		if(n == 0) return result;
		Arrays.sort(nums);
		List<Integer> cache = new ArrayList<>();
		boolean[] used = new boolean[n];
		helper(nums, result, cache, used, 0, n);
		return result;
	}
	
	/**
	 * 
	 * @param nums 传递的数组
	 * @param result 结果
	 * @param cache 缓冲，记录当前构成的全排列缓冲，
	 * @param used 记录当前缓冲中缓冲了那些数字，对应的数字其为true。因为对于当前递归层次来说，used[i] = true表明它出现在了之前的层次中，
	 * @param curr 全排列的当前位置
	 * @param n 数组长度
	 */
	private static void helper(int[] nums, List<List<Integer>> result, List<Integer> cache, boolean[] used, int curr, int n) {
		//基准情形,cache中已经构建了一个完整，正确的全排列情况
		if(curr == n) {
			List<Integer> oneAns = new ArrayList<>(cache);
			result.add(oneAns);
			return;
		}
		
		for(int i = 0;i < n;++i) {
			if(used[i]) continue;
			if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])//这里保证三点，首字母无视，当前位置，相同字母只选一个，为了保证正确性，如果前面那个数字用过了，虽然里连续但是还是可以
				continue;
			cache.add(nums[i]);
			used[i] = true;
			helper(nums, result, cache, used, curr + 1, n);
			used[i] = false;
			cache.remove(cache.size() - 1);
		}
	}
}
