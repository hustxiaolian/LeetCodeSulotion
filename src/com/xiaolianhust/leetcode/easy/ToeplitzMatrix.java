package com.xiaolianhust.leetcode.easy;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isToeplitzMatrix(new int[][] {
			{1,2,3,4},
			{5,1,2,3},
			{9,5,3,2}
		}));
	}
	
	/**
	 * 思路:
	 * 一行行的扫描，每次比较相两行错开一格。
	 * 即i-1向右移动一格后，与i行对应的位置的元素是否相等。
	 * 
	 * test1: 22ms, beats 19.00%ε=ε=ε=┏(゜ロ゜;)┛
	 * 前排大佬，利用数学关系能够，更好地利用告诉缓冲优化速度。
	 * 当然，前排有些代码明明和我一样，也是不知道为什么比我快这么多（大雾
	 * 
	 * @param matrix
	 * @return
	 */
	public static boolean isToeplitzMatrix(int[][] matrix) {
        int rn = matrix.length, cn = matrix[0].length;
        for(int i = 1;i < rn ;++i) {
        	for(int j = 1;j < cn ;++j) {
        		if(matrix[i][j] != matrix[i - 1][j - 1])
        			return false;
        	}
        }
        return true;
    }
}
