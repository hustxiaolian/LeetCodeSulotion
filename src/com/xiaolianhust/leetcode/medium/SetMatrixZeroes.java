package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
	}

	/**
	 * 第一种思路：
	 * 一行一行的向下扫描，使用一个数组来记录那些列应该为变为0，并且向上追溯，把该变为0的变调。
	 * 但是使用常数空间的方法我确实暂时没想到合适，有一个思路可以做到（见第二种思路），但是我觉得实在太浪费时间了。
	 * 
	 * 第二种思路：
	 * 遍历每个元素，遇到0则，向四周扩展填0直至边界。但是缺点是这也太耗时间了。
	 * 
	 * 第三种思路：
	 * 参考改编自discuss，即将扫描道的信息保存道首行，相当于把我第一种思路暂存数组放在首行，由此来达到不适用额外
	 * 空间的目的。
	 * 
	 * bug1:运行中修改，导致更下面的行没法知道，这个零到底是原本有的，还是后来修改的。
	 * 
	 * test1:2ms, beats 92.70%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 总结，有时候中间变量不一定要新建一个数组来保存，我们可以将他放在输入变量本地。
	 * 关键是它要不影响，或者说还要对最终结果的计算有好处。
	 * 
	 * @param matrix
	 */
    public static void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	if(m == 0) return;
    	int n = matrix[0].length;
    	boolean flagFirstRow = false;
    	//检查首行是否有零，置位标记位
    	for(int i = 0;i < n;++i) {
    		if(matrix[0][i] == 0) {
    			flagFirstRow = true;
    			break;
    		}
    	}
    	boolean flagCurrRow = false;
    	//开始检查其他下面的行
    	for(int i = 1;i < m;++i) {
    		for(int j = 0;j < n;++j) {
    			if(matrix[i][j] == 0) {
    				matrix[0][j] = 0;
    				flagCurrRow = true;
    			}
    		}
    		if(flagCurrRow) {
    			Arrays.fill(matrix[i], 0);
    			flagCurrRow = false;
    		}
    	}
    	
    	for(int j = 0;j < n; ++j) {
    		if(matrix[0][j] == 0) {
    			for(int k = 1;k < m;++k)
    				matrix[k][j] = 0;
    		}
    	}
    	
    	if(flagFirstRow)
    		Arrays.fill(matrix[0], 0);
    }
}
