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
	 * һ����ֱ�ӵ�˼·��
	 * ʹ��һ����������ʱ���棬Ȼ��Ѻ�����ƶ���ǰ����ٰ�ǰ�벿�ֲ���.
	 * test1:0ms, beats 100%��=��=��=��(�b��b;)��
	 * �����ռ�����Է���û�������
	 * 
	 * ����discuss���Բۣ����̱�ѹ�ư����������������þ��񣬸ߣ�ʵ���Ǹߡ����ò�����
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
	 * �㣬ʵ����̫���ˡ�
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
