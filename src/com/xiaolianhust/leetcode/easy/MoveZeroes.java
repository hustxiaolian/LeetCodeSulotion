package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * ˼·��
	 * ��ͨ��˼·���Ǳ����������飬�����ǰԪ��Ϊ0�� �����ƶ�������棬Ȼ������ǰ��һλ�����������������
	 * ʱ�临�Ӷȡ�n^n;̫���ˡ�
	 * 
	 * �Ľ�˼·��
	 * ʹ������ָ�룬��θĻ�˼·��
	 * 1. ���ȱ������飬Ѱ�ҵ�һ��0Ԫ�أ���p1ָ������
	 * 2. Ȼ�󴴽��ڶ���ָ��p2�������������飬Ѱ�ҷ�0Ԫ��ʱ������Ԫ�ظ�ֵ��p1����Ȼ��p1ָ����ǰ�ƶ�һ����
	 * 3. ֪��p2�����Ȼ���p1ָ���Ժ������λ�ø�ֵΪ0��
	 * 
	 * test1:2ms, beats 36.78%��=��=��=��(�b��b;)��
	 * ����discuss������˼·��һ�µģ�����ʡ���ҵĵ�һ���֡��ٶȸ���һ��㡣
	 * 
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
        int p1, n = nums.length;
        for(p1 = 0;p1 < n;++p1)
        	if(nums[p1] == 0)
        		break;
        if(p1 == n) return;
        int p2;
        for(p2 = p1 + 1;p2 < n;++p2) 
        	if(nums[p2] != 0)
        		nums[p1++] = nums[p2];
        for(;p1 < n;++p1)
        	nums[p1] = 0;
    }
}
