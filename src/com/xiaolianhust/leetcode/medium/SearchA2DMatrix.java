package com.xiaolianhust.leetcode.medium;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchMatrix(new int[][] {{}}, 1));
	}
	
	/**
	 * ��һ��˼·��
	 * �����ڵ�һ��ִ�ж���������
	 * �ж���< rowMax����ִ�ж���������
	 * 
	 * test1:12ms, beats 48.37%��=��=��=��(�b��b;)��
	 * 
	 * �ڶ���˼·��
	 * �ο��˱��Ҹ���һЩ�˵�˼·�����Ǹ��������о������ʣ��;��������Ĺ�ϵ
	 * ֱ���ھ�����ʹ�ö���������
	 * test1:11ms ,beat 95.25%��=��=��=��(�b��b;)��
	 * 
	 * �ܽ�����ԭ�򣬾�����ѭ��������С���м���̸���һЩ��
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
    	//�ж�target�ھ�������������
        if(target > matrix[m - 1][n - 1] || target < matrix[0][0])
        	return false;
        
        //�ڵ�һ��ִ�ж�������
        int left = 0, right = m - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(target < matrix[mid][0])
        		right = mid - 1;
        	else if(target > matrix[mid][0])
        		left = mid + 1;
        	else 
        		return true;
        }
        
        //ֻ�ø���left���жϾ��У�left - 1�����жϳ���������
        int currRowIndex = left - 1;
        left = 0;
        right = n - 1;
        int[] currRow = matrix[currRowIndex];
        if(target > currRow[n - 1])
        	return false;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(target < currRow[mid])
        		right = mid - 1;
        	else if(target > currRow[mid])
        		left = mid + 1;
        	else 
        		return true;
        }
    	return false;
    }
    
    public static boolean searchMatrix2(int[][] matrix, int target) {
    	int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
    	//�ж�target�ھ�������������
        if(target > matrix[m - 1][n - 1] || target < matrix[0][0])
        	return false;
        
        int left = 0, right = m * n - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(target < matrix[mid / n][mid % n])
        		right = mid - 1;
        	else if(target > matrix[mid / n][mid % n])
        		left = mid + 1;
        	else
        		return true;
        }
    	
    	return false;
    }
}
