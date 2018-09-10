package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(intersection(new int[] {4,9,5},
				new int[] {9,4,9,8,4})));
	}
	
	/**
	 * 思路：
	 * 1. 使用标准库排序。
	 * 2. 使用两个指针来完成比对。
	 * 
	 * ps:使用两个while，来避免重复插入。
	 * 
	 * test: 2ms, beats 98.94% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while(i < n1 && j < n2) {
        	if(nums1[i] > nums2[j]) {
        		++j;
        	} else if(nums1[i] < nums2[j]) {
        		++i;
        	} else {
        		ret.add(nums1[i]);
        		++i;++j;
        		while(i < n1 && nums1[i] == nums1[i - 1])
        			++i;
        		while(j < n2 && nums2[j] == nums2[j - 1])
        			++j;
        	}
        }
        
        int[] result = new int[ret.size()];
        for(int k = 0;k < ret.size();++k) {
        	result[k] = ret.get(k);
        }
        return result;
        
    }

}
