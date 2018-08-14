package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ֱ��hashtable����¼����ѯ���ɡ�
	 * test1:10ms, beats 63.02%��=��=��=��(�b��b;)��
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
        	if(set.contains(num))
        		return true;
        	set.add(num);
        }
        return false;
    }
	
	/**
	 * �����ʽ����Ȼ�����滹�п���һ������Ȼ��׼��������Ǿ���������Ż��ˡ�
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0;i < n;++i)
			if(nums[i] == nums[i + 1]) return true;
		return false;
	}
}
