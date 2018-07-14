package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1};
		rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 一种最直接的思路，
	 * 使用一个子数组暂时储存，然后把后面的移动到前面后，再把前半部分补上.
	 * test1:0ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * 常数空间的线性方法没想出来。
	 * 
	 * 看了discuss，卧槽，智商被压制啊，厉害。巧妙利用镜像，高，实在是高。不得不服。
	 * 
	 * @param nums
	 * @param k
	 */
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		int kk;
		if((kk = k % n) == 0) return;
		int d = n - kk;
        int[] sub = Arrays.copyOfRange(nums, 0, d);
        for(int i = 0;i < n - d;++i) 
        	nums[i] = nums[i + d];
        for(int i = n - d, j = 0;i < n;++i,++j) 
        	nums[i] = sub[j];
    }
	
	/**
	 * 秀，实在是太秀了。
	 * @param nums
	 * @param k
	 */
	public static void rotateBymirror(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0 ,n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private static final void reverse(int[] nums, int left, int right) {
		while(left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			--right;
		}
	}

}
