package com.xiaolianhust.leetcode.medium;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
	}
	
	/**
	 * ˼·:
	 * ��ӹ���ɣ����ַ���
	 * ������ת�Ժ��������һ����������ʣ��Ǿ�������ת�㸽�����������������ڲ�ֵ��
	 * ����ڶ��������Ĺ����У�Ӧ�������������Ҳ�ֵ�ĵط�ȥ��
	 * ����ֻ����Ѿ���ת�ķ�����Ч��
	 * 
	 * bug1:{1,2}�������룬Ҳ����˵��û��ת���ж���û����ת�ķ�������ֱ�ӿ���һ��Ԫ�غ����һ��Ԫ�صĴ�С��
	 * ��ˣ�����һ���жϼ��ɡ�
	 * 
	 * ������discuss����Ȼ�ǰ��ɹ���������ͨ����
	 * 
	 * �����������У������Զ���ұ�С��������ת�����ǿ��Ը������ֶϲ��������ת�㡣
	 * discuss���������¼��㣺
	 * 1. ��������Ǳ�ڵ������ƶ���
	 * 2. ��ת����󣬿��Ը�����߻����ұ����ֻ�׼���жϵ��������滹�����档
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		if(nums[left] < nums[right]) return nums[left];
		while(left + 1< right) {
			int mid = (left + right) / 2;
			int midVal = nums[mid];
			if(Math.abs(midVal - nums[left]) > Math.abs(midVal - nums[right]))
				right = mid;
			else
				left = mid;
		}
		return nums[right];
    }
	
	public static int findMin2(int[] nums) {
		int left = 0, right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] > nums[right]) 
				left = mid + 1;
			else
				right = mid;
		}
		return nums[left];
	}
}
