package com.xiaolianhust.leetcode.medium;

/**
 * 
 * @author 25040
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


 */
public class SearchForARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchRange1(new int[] {8,8}, 8);
	}
	
	/**
	 * ˼·������ʹ�ö���������
	 * 0.��ʼ���������������������
	 * 1.����ʹ�ö������������ҵ����������.Ȼ����ȷ����Χ��
	 * 2.1 ʹ����İ취��������
	 * 2.2 ���ҵ��и�Ԫ�ص���������������ö��ַ���ȷ���߽硣
	 * 
	 * test1:7ms, beats 100%(��=��=��=��(�b��b;)��)��������㷨��������
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] searchRange1(int[] nums, int target) {
    	int[] result = new int[] {-1, -1};
        int left = 0, right = nums.length - 1;
        if(nums.length == 0) return result;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(nums[mid] < target) {
        		left = mid + 1;
        	}
        	else if(target < nums[mid]) {
        		right = mid - 1;
        	}
        	else {
        		left = mid;
        		while(left > 0 && nums[left - 1] == nums[left])
        			left--;
        		right = mid;
        		while(right < nums.length - 1 && nums[right + 1] == nums[right])
        			right++;
        		result[0] = left;
        		result[1] = right;
                return result;
        	}
        }
        return result;
    }

}
