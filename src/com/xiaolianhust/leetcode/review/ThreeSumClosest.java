package com.xiaolianhust.leetcode.review;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4, 4}, 1));
	}
	
	
	/**
	 * 思路：
	 * 1. 建立一个窗口，计算相邻三个数字。
	 * 2. 遍历整个数组来寻找，和target差值最小的三个数字
	 * 
	 * 使用一个队列来作为窗口。
	 * 
	 * 看错题目了。。。不一定要是连续的。
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
	 * 利用3Sum的思路，排序后，然后外循环从左到右，而内循环从两边到中间。
	 * 
	 * test1: 22ms, beats 19.93 % ε=ε=ε=┏(゜ロ゜;)┛
	 * 好吧，我也前面的答案，思路形式都一样，莫名其妙差了一些，罢了。
	 * 果然是好久没写过了，手感有点生疏，不过没关系，我能感觉到，正在慢慢恢复
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
