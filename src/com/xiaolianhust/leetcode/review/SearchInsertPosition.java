package com.xiaolianhust.leetcode.review;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 2));
	}
	
	/**
	 * ˼·��
	 * ���������������ԣ������ԭ���Ķ�����������ֱ��ʹ�á�
	 * �����������������Ѱ�����Ƿ������������飬���������������valҪ���룬�Ͳ��������λ�á�
	 * test1: 3ms, beats 66.14% ��=��=��=��(�b��b;)��
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(target < nums[mid]) {
        		right = mid - 1;
        	} else if (target > nums[mid]) {
        		left = mid + 1;
        	} else {
        		return mid;
        	}
        }
        return left;
    }
}
