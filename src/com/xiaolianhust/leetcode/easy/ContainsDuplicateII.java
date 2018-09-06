package com.xiaolianhust.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}
	
	/**
	 * ˼·��
	 * ʹ��map�������飬����Ԫ�ؼ����Ӧ������
	 * test1:16ms ,beats 31.69%��=��=��=��(�b��b;)��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(map.containsKey(curr) && (i - map.get(curr)) <= k)
        		return true;
        	map.put(nums[i], i);
        }
        return false;
    }
	
	/**
	 * ʹ��һ���̶���С��set���൱��һ������Ϊk�Ĵ��ڡ�
	 * 
	 * test2:11ms, beats 79.63%��=��=��=��(�b��b;)��
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		if(k == 0) return false;
		HashSet<Integer> set = new HashSet<>();
		int n = nums.length;
		int i;
		for(i = 0;i < Math.min(k, n);++i) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		for(;i < n;++i) {
			if(set.contains(nums[i]))
				return true;
			set.remove(nums[i - k]);
			set.add(nums[i]);
		}
		return false;
	}
}
