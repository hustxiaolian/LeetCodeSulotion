package com.xiaolianhust.leetcode.review;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 这道题我记得相当的经典，让我第一次学习了从两端向中间遍历。
	 * 总的思路：先把宽拉到最大，然后双指针从两端向中间遍历，
	 * 每次比较左右的高度，移动低的那边，因为移动高的那边根本没有意义。
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        
        while(left < right) {
        	max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        	if(height[left] > height[right])
        		--right;
        	else
        		++left;
        }
        
        return max;
    }
}
