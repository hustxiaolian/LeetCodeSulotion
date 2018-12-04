package com.xiaolianhust.leetcode.review;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4, 4}, 1));
	}
	
	
	/**
	 * ˼·��
	 * 1. ����һ�����ڣ����������������֡�
	 * 2. ��������������Ѱ�ң���target��ֵ��С����������
	 * 
	 * ʹ��һ����������Ϊ���ڡ�
	 * 
	 * ������Ŀ�ˡ�������һ��Ҫ�������ġ�
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest1(int[] nums, int target) {
       int[] windows = new int[3];
       int tempSum = 0, wIndex = 0;
       for(int i = 0;i < 3;++i) {
    	   windows[i] = nums[i];
    	   tempSum += nums[i];
       }
       int closeValue = tempSum;
       for(int i = 3;i < nums.length;++i, wIndex = (wIndex + 1) % 3) {
    	   tempSum = tempSum - windows[wIndex] + nums[i];
    	   if(Math.abs(tempSum - target) < Math.abs(closeValue - target))
    		   closeValue = tempSum;
       }
       return closeValue;
    }
	
	/**
	 * ����3Sum��˼·�������Ȼ����ѭ�������ң�����ѭ�������ߵ��м䡣
	 * 
	 * test1: 22ms, beats 19.93 % ��=��=��=��(�b��b;)��
	 * �ðɣ���Ҳǰ��Ĵ𰸣�˼·��ʽ��һ����Ī���������һЩ�����ˡ�
	 * ��Ȼ�Ǻþ�ûд���ˣ��ָ��е����裬����û��ϵ�����ܸо��������������ָ�
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int result = 0, n = nums.length;
		result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for(int i = 0;i < n - 2; ++i) {
			int numi = nums[i];
			int j = i + 1, k = n - 1;
			while(j < k) {
				int tempSum = numi + nums[j] + nums[k];
				if(Math.abs(tempSum - target) < Math.abs(result - target))
					result = tempSum;
				if(tempSum < target) 
					++j;

				else if(tempSum > target) 
					--k;
				else
					return tempSum;
			}
		}
		return result;
	}
}
