package com.xiaolianhust.leetcode.easy;

public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pivotIndex(new int[] {}));
	}
	
	/**
	 * 思路：
	 * 用两个变量分别记录左边的sum和右边的sum。
	 * 遍历，如果sum1 = sum2 return.
	 * 
	 * 这相当于一个two-pass方案。
	 * 
	 * test1:29ms, beats 31.01%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 改进：我想这个one-pass方案，应该是两端向中间靠拢的方案。好吧，我高估了，前排的思路跟我一样。
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
        int allSum = 0;
        for(int num : nums)
        	allSum += num;
        int n = nums.length;
        if(n == 0) return -1;
        int leftSum = 0, rightSum = allSum - nums[0];
        if(leftSum == rightSum) return 0;
        for(int i = 1;i < n; ++i) {
        	leftSum += nums[i - 1];
        	rightSum -= nums[i];
        	if(leftSum == rightSum)
        		return i;
        }
        return -1;
    }
	
	public static int pivotIndex2(int[] nums) {
		int allSum = 0;
        for(int num : nums)
        	allSum += num;
        int n = nums.length;
        int temp = 0;
        for(int i = 0;i < n; ++i) {
        	if(allSum - nums[i] - temp == temp)
        		return i;
        	temp += nums[i];
        }
        return -1;
	}
}
