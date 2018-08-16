package com.xiaolianhust.leetcode.medium;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(robByDP2(new int[] {2,17,9,3,10}));
	}
	
	/**
	 * ˼·��
	 * ���ȿ�����һ���ݹ�˼·��
	 * �Ҳ²⣬���տ϶���dp���ġ�
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
		//��׼����
		if(start >= n)
			return 0;
		
		//һ������
		int result = 0;
		for(int i = start;i < n;++i) {
			result = Math.max(result, nums[i] + helper(nums, i + 2, n));
		}
		return result;
	}
	
	/**
	 * Ȼ����dp������·����
	 * 1. �����׼���Ρ�����֪f(0...i - 1),f(0...i - 2)����֮ǰ�����С�
	 * 2. �������⣬���ǵ�ǰ�����Ρ�
	 * 2.1 nums[i] + f(0...i-2)
	 * 2.2 nums[i] + f(0...i-3)
	 * 2.3 f(0...i-1)
	 * 
	 * ��������ȡ���ֵ�������ʣ�Ϊʲôû��nums[i] + f(0...i-4)
	 * ��Ϊnums[i]+f(0..i-2)  = nums[i] + nums[i - 2] + f(0...i - 4) > nums[i] + f(0...i - 4)�������ơ�
	 * 
	 * �Ƚ��鷳���Ǳ߽����Σ�ǰ��������Ҫ�����㡣֮��ֱ�Ӱ���������ʽ���㼴�ɡ�
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
	 * ����˼·��ֱ���ʵʵ�������������ֵ�˼·�ļ򻯰棬�������ּ��������
	 * ������û������������
	 * 
	 * @param nums
	 * @return
	 */
	public static int robByDP2(int[] nums) {
		int rob = 0, notrob = 0;//rob��ʾ������˵�ǰ���ݺ��ܵĲƸ����෴��notrob��ʾ������ǰ���ݣ��ܵ����档
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			int currrob = nums[i] + notrob;//�������ǰ���ݣ���ôi-1�ķ��ݾͲ�������
			notrob = Math.max(notrob, rob);//���������ǰ���ݣ���ô���Ǵ�i-1�������߲�����ȡ���ֵ��
			rob = currrob;//����ǰ���˼���ֵ����ֵ����
		}
		return Math.max(rob, notrob);
	}
}
