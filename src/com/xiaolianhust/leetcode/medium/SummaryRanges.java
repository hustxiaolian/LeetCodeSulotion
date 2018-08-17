package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(summaryRanges(new int[] {0,2,3,4,6,8,9}));
	}
	
	/**
	 * ˼·��
	 * һ�����⣬Ŀ��ǳ���������Ŀ���������Լȶ�˼·�������ˡ�
	 * �ж��������ڵ�����Ԫ���Ƿ����㣺nums[i] + 1 == nums[i + 1]
	 * ����ͼ���ѭ�������������һ��sub summary
	 * 
	 * test1:
	 * @param nums
	 * @return
	 */
	public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return result;
        int lo = 0, i;
        for(i = 0;i < n - 1;++i) {
        	if(nums[i] + 1 != nums[i + 1]) {
        		if(lo == i) 
        			result.add(String.valueOf(nums[lo]));
        		else 
        			result.add(nums[lo] + "->" + nums[i]);
        		lo = i + 1;
        	}
        }
        if(lo == i) 
			result.add(String.valueOf(nums[lo]));
		else 
			result.add(nums[lo] + "->" + nums[i]);
        return result;
    }

}
