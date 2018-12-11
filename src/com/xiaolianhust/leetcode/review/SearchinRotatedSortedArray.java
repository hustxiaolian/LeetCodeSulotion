package com.xiaolianhust.leetcode.review;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * 1. �����ҵ���ת�㡣����������ת�ˣ���ô��������ֵ����Сֵ�����ڵġ�
	 * 		ʹ��˫ָ��ƽ��������������м�ƽ������������Ԫ�����������+���ǵ�Ŀ�ģ���ˣ���target>mid,left=mid + 1, ����right = mid
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if(right < 1) return -1;
		if(nums[left] > nums[right]) {
			int rightVal = nums[right];
			while(left < right) {
				int mid = (left + right) / 2;
				if(rightVal < nums[mid])
					right = mid;
				else
					left = mid + 1;
			}
			if(target >= nums[0]) {
				right = left - 1;
				left = 0;
			} else {
				right = nums.length - 1;
			}
		}
		while(left <= right) {
			int mid = (left + right) / 2;
			if(target < nums[mid])
				right = mid - 1;
			else if (target > nums[mid])
				left = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
