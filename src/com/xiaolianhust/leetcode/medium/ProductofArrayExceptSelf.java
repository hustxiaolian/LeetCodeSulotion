package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
	}	
	
	/**
	 * 思路：
	 * 
	 * 1. 很显然的方案就是将所有元素乘起来然后ret / nums[i]，但是
	 * 
	 * 从另一方面看，每个位置上的元素就是他左边元素的乘积 * 右边元素的乘积，由于不能用除法
	 * 所以必须要两遍才行，第一遍从左到右，在各元素上赋值该元素左边的乘积
	 * 第二遍，从右到左，再乘以各元素该元素右边的乘积。
	 * 
	 * test3: 3ms, ε=ε=ε=┏(゜ロ゜;)┛
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
