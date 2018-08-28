package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {2,0,2,1,1,0};
		sortColors(c);
		System.out.println(Arrays.toString(c));
	}
	/**
	 * 思路：
	 * 首先按照counting sort的方式，做一遍，回顾复习下基数排序
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
        int[] colorNum = new int[3];
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	switch (nums[i]) {
			case 0: ++colorNum[0];break;
			case 1: ++colorNum[1];break;
			case 2: ++colorNum[2];break;
			}
        }
        for(int i = 0, index = 0;i < 3;++i) {
        	int currNum = colorNum[i];
        	for(int j = 0;j < currNum;++j,++index) {
        		nums[index] = i;
        	}
        }
    }
	
	/**
	 * 哎，我想到这种思路，但是还是建立在交换的前提下，没有想到这种666的方法，谢谢，学习了。
	 * 随后，再次复习了下快排的lumuto partition算法：
	 * 两个指针i,j,i指向前面>pivot的位置，j一开始跟他同一位置，j从前向后遍历，if(nums[j] <= pivot)
	 * 那么交换i，j位置的元素，然后i++，这样保证了前半部分一定是<=pivot的元素。谢谢。
	 * @param nums
	 */
	public static void sortColors2(int[] nums) {
		int redIndex = 0,whiteIndex = 0, n = nums.length;
		for(int i = 0;i < n;++i) {
			int temp = nums[i];
			nums[i] = 2;
			if(temp < 2)
				nums[whiteIndex++] = 1;
			if(temp == 0)
				nums[redIndex++] = 0;
		}
	}
}
