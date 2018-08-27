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
	 * ˼·�����û��ݷ�����
	 * �����õݹ�˼·��������ÿ���ݹ�������-һ������֪��ȫ�����.
	 * ��������˳��ͬ��Ҳ�ǲ�ͬ�Ĵ𰸡�����ÿ�ֵݹ鶼�Ǵӵ�һ�����ֿ�ʼ��
	 * 
	 * test:TLE,��ʱ���Ҿ�֪����û�¡�
	 * 
	 * ���ڴˣ�˼��dp��˼·��
	 * 
	 * �ܽ��¸����dp˼·��
	 * 1. �������Լ�f(i - 1)����֮ǰ���е���ȷ�����
	 * 2. ��������͵�ǰ���Σ����i(����iָ���ǣ�nums�е����ּ�����=i����ϵĸ���)
	 * ��ôҪ����õ�ǰnums�е���i�����֣�Ҳ����i��ȥnums�е�ĳ�����֣�Ȼ���ѯ��������ǰ�����Ľ����
	 * 
	 * ��������nums�������֣�ÿ�νԲ�ѯi-nums[j]�Ľ����Ȼ������Ǽ�������ͣ�����i������ϵĸ�����
	 * 
	 * 3. �߽��������i=0��ʱ������ʾi-nums[i]�����Ϊ0��Ҳ�������ֻ��һ�����ֵ���������f(0) = 1
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
	 * ���������ݹ�dp.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum42(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;//��׼����
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
	 * ���µ��ϣ���dp��
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
