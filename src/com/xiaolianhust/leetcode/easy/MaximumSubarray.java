package com.xiaolianhust.leetcode.easy;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-2,1}));
	}
	
	/**
	 * ˼·��
	 * �����㷨��˼·�����������ݽṹ���ϵ�һ�����Ҵ��۽����Ŀ��
	 * 
	 * ����ѧϰ��dp��Ӧ�úú�ʹ��dp��˼·��˼���ܽ��£�
	 * 1. �����׼���Σ�
	 * f(0..i-1)����֮ǰ�������֪�����ڿ��������subSum�ı�������֪���������൱������
	 * 
	 * 2.���ݵ�ǰ��������ǡ�
	 * 2.1�ж�ǰ���subSum < 0�������˵��ǰ����һ��û�м��ϵı�Ҫ�����ۺ��ˣ�ֱ����0��Ȼ���ȡnums[i]��Ϊ��subSum
	 * 2.2���2.1����������ô˵��ǰ���Ǵ����м�ֵ�����ϵ�ǰֵ�ж��Ƿ�>result���������ֵ���������ֱ��������һ��
	 * 
	 * test1:11ms, beats 10.91%��=��=��=��(�b��b;)�����գ���ô�������ҿ���ǰ����е��Ż������
	 * �ðɣ����������Ǹ�����������ж�Ҫ������ͨ������˳����Ը��Ӽ�ࡣ
	 * 
	 * test2:9ms,beats 52.00%��=��=��=��(�b��b;)��
	 * 
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int result = nums[0];
        int subSum = nums[0];
        
        for(int i = 1;i < n;++i) {
        	if(subSum < 0)
        		subSum = 0;
        	subSum += nums[i];
        	if(subSum > result) 
        		result = subSum;
        }
        
        return result;
    }
    
    /**
     * ������ϸ�˼·����һ�������ǵ����½ṹ�����Լ���if(n==0)���ж�
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
    	int n = nums.length;
    	int result = Integer.MIN_VALUE;
    	int subSum = 0;
    	for(int i = 0;i < n;++i) {
    		subSum += nums[i];
    		if(subSum > result)
    			result = subSum;
    		if(subSum < 0)
    			subSum = 0;
    	}
    	return result;
    }

}
