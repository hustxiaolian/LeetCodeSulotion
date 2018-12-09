package com.xiaolianhust.leetcode.review;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	
	/**
	 * ˼·��
	 * ˫ָ������������������̡�
	 * ָ��i���������е�ÿ��Ԫ�أ�ָ��j������nums[i] > nums[j]��ʱ����ƶ����Ҹ�ֵ��
	 * 
	 * test 1: 7ms, beats 80.96%
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int j = 0;
		for(int i = 1;i < n; ++i) {
			if(nums[i] > nums[j])
				nums[++j] = nums[i];
		}
		return j + 1;
	}
}
