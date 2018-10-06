package com.xiaolianhust.leetcode.review;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * 1. ʹ��һ��hashset����¼֮ǰ���ֵ��������֡�
	 * 2. ÿ�ζ��ж��Ƿ�hashset.contain(target-nums[i])
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i) {
        	if(map.containsKey(target - nums[i]))
        		return new int[] {map.get(target - nums[i]), i};
        	map.put(nums[i], i);
        }
        return null;//�����൱����˼�¡�
    }
}
