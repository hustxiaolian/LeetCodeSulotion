package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths2(7, 3));
	}
	
	/**
	 * ��һ��˼·��
	 * ��ʼ������ǰ���õ���¥�ݣ�ֻ��1����2�������������
	 * ��ݹ������˼·��F(m,n) = F(m-1,n) + F(m,n-1)
	 * ����F(x,1) = F(1,y) = 1
	 * ��˶���һ����ά�������ݴ���������̵��м���̡�
	 * 
	 * ������õݹ飬������ܶ����õĵݹ顣
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
     * �ڶ���˼·��
     * �ڵ�һ��˼·�Ļ����ϣ�ֻʹ��һά�������ݴ����ݡ�
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
