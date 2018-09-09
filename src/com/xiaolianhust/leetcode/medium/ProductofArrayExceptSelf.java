package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
	}	
	
	/**
	 * ˼·��
	 * 
	 * 1. ����Ȼ�ķ������ǽ�����Ԫ�س�����Ȼ��ret / nums[i]������
	 * 
	 * ����һ���濴��ÿ��λ���ϵ�Ԫ�ؾ��������Ԫ�صĳ˻� * �ұ�Ԫ�صĳ˻������ڲ����ó���
	 * ���Ա���Ҫ������У���һ������ң��ڸ�Ԫ���ϸ�ֵ��Ԫ����ߵĳ˻�
	 * �ڶ��飬���ҵ����ٳ��Ը�Ԫ�ظ�Ԫ���ұߵĳ˻���
	 * 
	 * test3: 3ms, ��=��=��=��(�b��b;)��
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        ret[0] = 1;
        for(int i = 1;i < n;++i) {
        	ret[i] = ret[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for(int i = n - 2;i >= 0;--i) {
        	tmp *= nums[i + 1];
        	ret[i] *= tmp; 
        }
        return ret;
    }

}
