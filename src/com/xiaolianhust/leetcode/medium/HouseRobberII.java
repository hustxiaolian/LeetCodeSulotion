package com.xiaolianhust.leetcode.medium;

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob2(new int[] {1,2}));
	}

	/**
	 * 思路：
	 * 这道题肯定是使用dp来做，这几天沉迷科研，感觉好久都没好好写代码了。
	 * 今天中午科研完成了一个阶段目标，写写代码，放松下。
	 * 还是写代码愉悦。
	 * 
	 * 为了恢复感觉，先写下递归思路。
	 * 目标是：抢劫更多的钱，相邻的两个会触发警报，街道是一个环形街道，首尾相连。
	 * 递归思路：
	 * 离当前的地方，至少隔开一个，然后相加，然后递归到下一层次。
	 * 选择一个result最大的路径。
	 * 
	 * test1: TLE, (*^_^*)我就知道，其实令我恼火的是，好久没刷leetcode了，那种解题的手感有点降低。
	 * 
	 * 没事，慢慢来，以后科研还是得适度，保证每天足够的编码时间很重要。
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		int n = nums.length;
		int result = 0;
        for(int i = 0;i < n;++i) {
        	result = Math.max(result, nums[i] + helper(nums, i + 2, i + n, n));
        }
        return result;
    }

	private static int helper(int[] nums, int start, int end, int n) {
		if(start + 1 >= end)
			return 0;
		
		int result = 0;
		for(int i = start;i < end - 1;++i) {
			result = Math.max(result, nums[i % n] + helper(nums, i + 2, end, n));
		}
		return result;
	}
	
	/**
	 * 思路：
	 * 既然我们知道了rob第一种版本的解决方法，那么这次的环形街道。其实本质还是和前面一样。
	 * 假设我们从第一个房子开始抢，那么最后一个房子，我们别碰，或者我们从第二个房子开始，那么最后一个房子就可以碰。
	 * 仔细思考，可以发现，这两种方式可以囊括住所有的情况。妙。
	 * 
	 * test1: 3ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static int rob2(int[] nums) {
		int n = nums.length;
		if(n == 0) return 0;
		else if(n == 1) return nums[0];
		return Math.max(robDP(nums, 0, n - 2), robDP(nums, 1, n - 1));
	}

	private static int robDP(int[] nums, int start, int end) {
		int rob = 0, notrob = 0;
		for(int i = start;i <= end;++i) {
			int currrob = nums[i] + notrob;
			notrob = Math.max(notrob, rob);
			rob = currrob;
		}
		return Math.max(rob, notrob);
	}
	
	
	
	
}
