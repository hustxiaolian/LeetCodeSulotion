package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class CombinationSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIV c = new CombinationSumIV();
		System.out.println(c.combinationSum4(new int[] {1,2,4}, 4));
		
	}
	
	private int result = 0;
	
	/**
	 * 思路：先用回溯法做。
	 * 即先用递归思路做出来。每个递归层次依次-一个数字知道全部完成.
	 * 由于数字顺序不同，也是不同的答案。所以每轮递归都是从第一个数字开始。
	 * 
	 * test:TLE,超时。我就知道，没事。
	 * 
	 * 基于此，思考dp的思路。
	 * 
	 * 总结下该题的dp思路：
	 * 1. 假设我以及f(i - 1)及其之前所有的正确结果。
	 * 2. 根据题意和当前情形，针对i(这里i指的是：nums中的数字加起来=i的组合的个数)
	 * 那么要想求得当前nums中等于i的数字，也就是i减去nums中的某个数字，然后查询该数字在前面计算的结果。
	 * 
	 * 遍历整个nums所有数字，每次皆查询i-nums[j]的结果，然后把他们加起来求和，就是i所有组合的个数。
	 * 
	 * 3. 边界情况，当i=0的时候，他表示i-nums[i]后更好为0，也就是组合只有一个数字的情况，因此f(0) = 1
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum4(int[] nums, int target) {
		result = 0;
		Arrays.sort(nums);
		int n = nums.length;
        helper(nums, target, n);
        return result;
    }

	private void helper(int[] nums, int remain, int n) {
		if(remain == 0) {
			++result;
			return;
		}
		
		for(int i = 0;i < n;++i) {
			if(nums[i] > remain) break;
			helper(nums, remain - nums[i], n);
		}
	}
	
	/**
	 * 备忘法，递归dp.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum42(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;//基准情形
		helper2(dp, target, nums);
		return dp[target];
	}

	private int helper2(int[] dp, int target, int[] nums) {
		if(dp[target] != -1) {
			return dp[target];
		}
		int res = 0;
		for(int i = 0;i < nums.length; ++i) {
			if(target - nums[i] >= 0) {
				res += helper2(dp, target - nums[i], nums);
			}
		}
		dp[target] = res;
		return res;
	}
	
	/**
	 * 从下到上，真dp。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum43(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		int n = nums.length;
		for(int i = 1;i <= target; ++i) {
			int res = 0;
			for(int j = 0;j < n;++j) {
				if(i - nums[j] >= 0) {
					res += dp[i - nums[j]];
				}
			}
			dp[i] = res;
		}
		return dp[target];
	}
}
