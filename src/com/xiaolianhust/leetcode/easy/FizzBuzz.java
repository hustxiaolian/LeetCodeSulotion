package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(15));
	}
	
	/**
	 * 思路：
	 * 正常做就完事了，先把3的位置欢成Fizz，然后将把5的倍数欢成Buzz，碰到公倍数就是FizzBuzz。
	 * 然后再把数字放上去。
	 * 
	 * test1: 2ms, beats 99.85% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        for(int i = 3;i <= n;i += 3) {
        	result[i - 1] = "Fizz";
        }
        for(int i = 5;i <= n;i += 5) {
        	if(result[i - 1] == null)
        		result[i - 1] = "Buzz";
        	else
        		result[i - 1] += "Buzz";
        }
        
        for(int i = 1;i <= n;++i) {
        	if(result[i - 1] == null)
        		result[i - 1] = String.valueOf(i);
        }
        return Arrays.asList(result);
    }
}
