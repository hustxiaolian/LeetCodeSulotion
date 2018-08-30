package com.xiaolianhust.leetcode.easy;

public class ReshapetheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	/**
	 * 思路：
	 * 按照直觉思路来，就行。
	 * 
	 * test1:5ms, beats 60.78%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums == null) return nums;
        int rn = nums.length;
        int cn = nums[0].length;
        if(rn * cn != r * c) return nums;
        
        int[][] result = new int[r][c];
        for(int i = 0;i < r * c; ++i) {
        	result[i / c][i % c] = nums[i / cn][i % cn];
        }
        return result;
    }

}
