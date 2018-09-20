package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(intersect2(new int[] {4,9,5}, new int[] {9,4,9,8,4})));;
	}
	
	/**
	 * 思路：
	 * 1. 首先将两个数组排序。然后使用双指针来做。
	 * test:4ms
	 * 
	 * 改进：不适用list来改进。
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2= nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n1 && j < n2) {
        	if(nums1[i] < nums2[j]) {
        		i++;
        	} else if(nums1[i] > nums2[j]) {
        		j++;
        	} else {
        		res.add(nums1[i]);
        		i++;j++;
        	}
        }
        int[] result = new int[res.size()];
        i = 0;
        for(int num : res)
        	result[i++] = num;
        return result;
    }
	
	/**
	 * test2: 2ms, 可怕的速度。果然是要尽量使用数组操作。
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect2(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2= nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(n1, n2)]; 
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
        	if(nums1[i] < nums2[j]) {
        		i++;
        	} else if(nums1[i] > nums2[j]) {
        		j++;
        	} else {
        		result[k++] = nums1[i]; 
        		i++;j++;
        	}
        }
        return Arrays.copyOf(result, k);
    }
}
