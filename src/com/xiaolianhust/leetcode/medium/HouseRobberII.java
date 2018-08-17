package com.xiaolianhust.leetcode.medium;

public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob2(new int[] {1,2}));
	}

	/**
	 * ˼·��
	 * �����϶���ʹ��dp�������⼸����Կ��У��о��þö�û�ú�д�����ˡ�
	 * ����������������һ���׶�Ŀ�꣬дд���룬�����¡�
	 * ����д�������á�
	 * 
	 * Ϊ�˻ָ��о�����д�µݹ�˼·��
	 * Ŀ���ǣ����ٸ����Ǯ�����ڵ������ᴥ���������ֵ���һ�����νֵ�����β������
	 * �ݹ�˼·��
	 * �뵱ǰ�ĵط������ٸ���һ����Ȼ����ӣ�Ȼ��ݹ鵽��һ��Ρ�
	 * ѡ��һ��result����·����
	 * 
	 * test1: TLE, (*^_^*)�Ҿ�֪������ʵ�����ջ���ǣ��þ�ûˢleetcode�ˣ����ֽ�����ָ��е㽵�͡�
	 * 
	 * û�£����������Ժ���л��ǵ��ʶȣ���֤ÿ���㹻�ı���ʱ�����Ҫ��
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
	 * ˼·��
	 * ��Ȼ����֪����rob��һ�ְ汾�Ľ����������ô��εĻ��νֵ�����ʵ���ʻ��Ǻ�ǰ��һ����
	 * �������Ǵӵ�һ�����ӿ�ʼ������ô���һ�����ӣ����Ǳ������������Ǵӵڶ������ӿ�ʼ����ô���һ�����ӾͿ�������
	 * ��ϸ˼�������Է��֣������ַ�ʽ��������ס���е�������
	 * 
	 * test1: 3ms, beats 100%��=��=��=��(�b��b;)��
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
