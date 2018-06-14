package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths2(7, 3));
	}
	
	/**
	 * 第一个思路：
	 * 起始这道题和前面拿到爬楼梯（只能1步和2步）的题意很像。
	 * 其递归迭代的思路：F(m,n) = F(m-1,n) + F(m,n-1)
	 * 其中F(x,1) = F(1,y) = 1
	 * 因此定义一个二维矩阵来暂存各迭代过程的中间过程。
	 * 
	 * 这里别用递归，会产生很多无用的递归。
	 * @param m
	 * @param n
	 * @return
	 */
    public static int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        for(int i = 0;i < m;++i) 
        	temp[i][n - 1] = 1;
        for(int i = 0;i < n;++i)
        	temp[m - 1][i] = 1;
        
        for(int i = m - 2;i >= 0; --i) {
        	for(int j = n - 2;j >= 0;--j) {
        		temp[i][j] = temp[i + 1][j] + temp[i][j + 1];
        	}
        }
        
        return temp[0][0];
    }
    
    /**
     * 第二个思路：
     * 在第一个思路的基础上，只使用一维数组来暂存数据。
     * 
     * @param p
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
    	int p, q;
    	if(m < n) {
    		p = m;
    		q = n;
    	}
    	else {
    		p = n;
    		q = m;
    	}
    	int[] temp = new int[p];
		Arrays.fill(temp, 1);
		for(int j = q - 2;j >= 0; --j) {
			temp[p - 1] = 1;
			for(int i = p - 2;i >= 0; --i) {
				temp[i] += temp[i + 1];
			}
		}
		return temp[0];
    }

}
