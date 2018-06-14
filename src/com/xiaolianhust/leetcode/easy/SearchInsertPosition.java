package com.xiaolianhust.leetcode.easy;


/**
 * 
 * @author 25040
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ˼·�϶��Ƕ��ֲ���,�������ʣ�����Ҳ�����ԭ�еĶ��ֲ��ҶԳ�һ���ĸĽ���
	 * ���ַ�����������ܹ�Ĭд������
	 * 
	 * ����Զ��ַ��ĸĽ������Ǽ���ǰ��������������жϡ�
	 * ͬʱ��retur��ֱ�ӷ���left������������и�Ԫ����ôֱ��return mid�����ˡ�
	 * ����������û�и�Ԫ�ص��������ô����ֵ�������
	 * 1. nums[left] < target < nums[right];left + 1 = right;����left = n- 1 ,right = n;
	 * 2. left = n, right = n;
	 * 3. right = n-1 ,left = n;������ֹ������������ַ����������е�nums������û��target��������������á�
	 * 
	 * test1:5ms, beats(100%,��=��=��=��(�b��b;)��)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        
        //�������������ֱ�ӷ���
        if(target <= nums[0]) return 0;
        if(target > nums[right]) return right + 1;
        
    	while(left <= right) {
    		mid = (left + right) / 2;
    		if(target > nums[mid])
    			left = mid + 1;
    		else if(target < nums[mid])
    			right = mid - 1;
    		else 
    			return mid;
    	}
    	
    	
    	return left;
    }
}
