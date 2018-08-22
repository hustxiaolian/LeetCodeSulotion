package com.xiaolianhust.leetcode.medium;

public class UglyNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 由于题目要求数字的因子只能为2.，3，5，那么其数字必然由2*x，3*y*,5*z，然后这三个数字相乘而来。
	 * 其中x，y,z为正整数，那么题目就编程3行数组归并排序的问题了。妙不可言。
	 * 同时，我们应当注意到重复问题。既保证下一个数字永远要大于。
	 * 
	 * test1: 5ms, beats 50.16%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        if(n <= 6)
        	return n;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int next2 = 2, next3 = 3, next5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        
        for(int i = 1;i < n;++i) {
        	int currMin = Math.min(Math.min(next2, next3), next5);
        	ugly[i] = currMin;
        	if(currMin == next2)
        		next2 = 2 * ugly[++index2];
        	if(currMin == next3)
        		next3 = 3 * ugly[++index3];
        	if(currMin == next5)
        		next5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
