package com.xiaolianhust.leetcode.medium;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchMatrix(new int[][] {{}}, 1));
	}
	
	/**
	 * 第一种思路：
	 * 首先在第一列执行二分搜索。
	 * 判断它< rowMax后，在执行二分搜索。
	 * 
	 * test1:12ms, beats 48.37%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 第二种思路：
	 * 参考了比我更快一些人的思路，就是根据题意中矩阵性质，和矩阵坐标间的关系
	 * 直接在矩阵上使用二分搜索。
	 * test1:11ms ,beat 95.25%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 总结更快的原因，就在于循环开销更小，中间过程更少一些。
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
    	//判断target在矩阵所在区间内
        if(target > matrix[m - 1][n - 1] || target < matrix[0][0])
        	return false;
        
        //在第一列执行二分搜索
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
        
        //只用根据left来判断就行，left - 1就是判断出来的区间
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
    	//判断target在矩阵所在区间内
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
