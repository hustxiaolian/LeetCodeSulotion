package com.xiaolianhust.leetcode.easy;

public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pivotIndex(new int[] {}));
	}
	
	/**
	 * ˼·��
	 * �����������ֱ��¼��ߵ�sum���ұߵ�sum��
	 * ���������sum1 = sum2 return.
	 * 
	 * ���൱��һ��two-pass������
	 * 
	 * test1:29ms, beats 31.01%��=��=��=��(�b��b;)��
	 * 
	 * �Ľ����������one-pass������Ӧ�����������м俿£�ķ������ðɣ��Ҹ߹��ˣ�ǰ�ŵ�˼·����һ����
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
        int allSum = 0;
        for(int num : nums)
        	allSum += num;
        int n = nums.length;
        if(n == 0) return -1;
        int leftSum = 0, rightSum = allSum - nums[0];
        if(leftSum == rightSum) return 0;
        for(int i = 1;i < n; ++i) {
        	leftSum += nums[i - 1];
        	rightSum -= nums[i];
        	if(leftSum == rightSum)
        		return i;
        }
        return -1;
    }
	
	public static int pivotIndex2(int[] nums) {
		int allSum = 0;
        for(int num : nums)
        	allSum += num;
        int n = nums.length;
        int temp = 0;
        for(int i = 0;i < n; ++i) {
        	if(allSum - nums[i] - temp == temp)
        		return i;
        	temp += nums[i];
        }
        return -1;
	}
}
