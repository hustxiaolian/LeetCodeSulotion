package com.xiaolianhust.leetcode.medium;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
	}
	
	/**
	 * 思路：
	 * 画图理解，就是一个变量环绕
	 * 
	 * @param matrix
	 */
    public static void rotate(int[][] matrix) {
    	int n = matrix.length;
    	int tail = n - 1;
        for(int i = 0;i < n / 2;++i) {
        	for(int j = i;j < n - 1 - i;++j) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[tail - j][i];
        		matrix[tail - j][i] = matrix[tail - i][tail - j];
        		matrix[tail - i][tail - j] = matrix[j][tail - i];
        		matrix[j][tail - i] = temp;
        	}	
        }  
    }
}
