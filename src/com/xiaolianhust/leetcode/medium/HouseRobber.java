package com.xiaolianhust.leetcode.medium;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(robByDP2(new int[] {2,17,9,3,10}));
	}
	
	/**
	 * 思路：
	 * 首先可以走一波递归思路。
	 * 我猜测，最终肯定是dp做的。
	 * 
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n);
    }

	private static int helper(int[] nums, int start, int n) {
		//基准情形
		if(start >= n)
			return 0;
		
		//一般情形
		int result = 0;
		for(int i = start;i < n;++i) {
			result = Math.max(result, nums[i] + helper(nums, i + 2, n));
		}
		return result;
	}
	
	/**
	 * 然后按照dp的老套路来：
	 * 1. 假设基准情形。即已知f(0...i - 1),f(0...i - 2)及其之前的所有。
	 * 2. 根据题意，考虑当前的情形。
	 * 2.1 nums[i] + f(0...i-2)
	 * 2.2 nums[i] + f(0...i-3)
	 * 2.3 f(0...i-1)
	 * 
	 * 上面三者取最大值，有人问，为什么没有nums[i] + f(0...i-4)
	 * 因为nums[i]+f(0..i-2)  = nums[i] + nums[i - 2] + f(0...i - 4) > nums[i] + f(0...i - 4)依次类推。
	 * 
	 * 比较麻烦的是边界情形，前面三个需要单独算。之后直接按照上述公式计算即可。
	 * @param nums
	 * @return
	 */
	public static int robByDP(int[] nums) {
		int n = nums.length;
		if(n == 0) return 0;
		int[] dp = new int[n];
		int nn = Math.min(n, 3);
		for(int i = 0;i < nn;++i) {
			switch(i) {
			case 0:
				dp[0] = nums[0];break;
			case 1:
				dp[1] = Math.max(nums[0], nums[1]);break;
			case 2:
				dp[2] = Math.max(nums[0] + nums[2], nums[1]);break;
			}
		}
		
		for(int i = 3;i < n;++i) {
			int curr = nums[i];
			dp[i] = Math.max(Math.max(curr + dp[i - 2], curr + dp[i - 3]), dp[i - 1]);
		}
		
		return dp[n - 1];
	}
	
	/**
	 * 这种思路简直妙，其实实质上上面我那种的思路的简化版，但是这种简化真是巧妙。
	 * 起码我没想出来。妙。美。
	 * 
	 * @param nums
	 * @return
	 */
	public static int robByDP2(int[] nums) {
		int rob = 0, notrob = 0;//rob表示如果抢了当前房屋后总的财富，相反，notrob表示不抢当前房屋，总的收益。
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			int currrob = nums[i] + notrob;//如果抢当前房屋，那么i-1的房屋就不能抢。
			notrob = Math.max(notrob, rob);//如果不抢当前房屋，那么我们从i-1的抢或者不抢中取最大值。
			rob = currrob;//将当前抢了计算值，赋值过来
		}
		return Math.max(rob, notrob);
	}
}
