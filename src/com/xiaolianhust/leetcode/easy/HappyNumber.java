package com.xiaolianhust.leetcode.easy;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(2));
	}
	
	/**
	 * 核心思路：
	 * 沿着题目的意思，一直持续下去。
	 * 
	 * test1:2ms, beats 76.36% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		return helper(n, new HashSet<Integer>());
    }

	private static boolean helper(int n, HashSet<Integer> hashSet) {
		//基准情形
		if(n == 1)
			return true;
		else if(hashSet.contains(n))
			return false;
		//一般情形
        int newSum = 0;
        hashSet.add(n);
        while(n != 0) {
        	int curr = n % 10;
        	newSum += curr * curr;
        	n = n / 10;
        }
        return helper(newSum, hashSet);
	}
	
	public static boolean isHappy2(int n) {
		int newVal = 0;
		HashSet<Integer> set = new HashSet<>();
		
		while(true) {
			if(n == 1) return true;
			if(set.contains(n)) return false;
			
			set.add(n);
			while(n != 0) {
				int curr = n % 10;
	        	newVal += curr * curr;
	        	n = n / 10;
			}
			n = newVal;
		}
	}
}
