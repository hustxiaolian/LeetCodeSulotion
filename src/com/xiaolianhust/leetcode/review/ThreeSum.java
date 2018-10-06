package com.xiaolianhust.leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[] {0,0,0}));
	}
	
	/**
	 * ˼·��
	 * 1. ������Ȼ�����ÿ��Ԫ�أ��������Ԫ��ʹ��ǰ������˵��м�ı�������
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < nums.length - 2; ++i) {
        	int target = -nums[i];
        	if(-target > 0) break;
        	if(i > 0 && -target == nums[i - 1]) continue;
        	int left = i + 1, right = nums.length - 1;
        	while(left < right) {
        		int tempSum = nums[left] + nums[right];
        		if(tempSum > target) {
        			--right;
        		} else if(tempSum < target) {
        			++left;
        		} else {
        			result.add(new ArrayList<>(Arrays.asList(-target, nums[left], nums[right])));
        			++left;--right;
        			while(left < right && nums[left] == nums[left - 1])
        				++left;
        			while(left < right && nums[right] == nums[right + 1])
        				--right;
        		}
        	}
        }
        return result;
    }
}
