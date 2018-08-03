package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRepeatedDnaSequences2("GAGAGAGAGAG"));
	}
	/**
	 * 思路：
	 * 首先理解清楚题目意思，她限定了这个substring只有10的长度。
	 * 这相当于一个窗口，我们滑动这个窗口即可。利用hashset记录前面的子串，后面的新子串先比对，然后如果没有则添加到新的子串中来
	 * 
	 * test1:31ms, beats 38.16%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 第二版本：
	 * 利用它只有a,c,g,t的特性，外加窗口不变连续移动的特点，可以自己定义hashcode运算，完成更高速度的计算。
	 * 
	 * test2:22ms, beats 95.97%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences(String s) {
		int n = s.length();
		HashSet<String> set = new HashSet<>();
		HashSet<String> result = new HashSet<>();
        for(int i = 10;i <= n;++i) {
        	String curr = s.substring(i - 10, i);
        	if(set.contains(curr)) {
        		result.add(curr);
        	}
        	else {
        		set.add(curr);
        	}
        }
        return new ArrayList<>(result);
    }
	
	static final int[] map2 = new int[10];
	static {
		map2[5] = 0;
		map2[7] = 1;
		map2[1] = 2;
		map2[4] = 3;
	}
	
	/**
	 * 将利用a，c，g，t的ascii的%10的余数各不相同，可以建立一个数组映射，然后将其变化为两个bit表示
	 * a-00
	 * c-01
	 * g-10
	 * t-11
	 * 十个ACGT字符组成的字符串，就可以用20个bit表示，
	 * 新的计算可以利用移位+掩码完成，节省了计算量。
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences2(String s){
		final int n = s.length();
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> resultset = new HashSet<>();
		List<String> result = new ArrayList<>();
		char[] sarr = s.toCharArray();
		int curr = 0, mask = ~((Integer.MIN_VALUE) >> 11);
		for(int i = 0;i < Math.min(10, n);++i) {
			char ch = sarr[i];
			int temp1 = ch % 10;
			int temp2 = map2[temp1];
			curr = (curr << 2) | temp2;
		}
		set.add(curr);
		for(int i = 10;i < n;++i) {
			curr = ((curr << 2) & mask) | map2[sarr[i] % 10];
			if(set.contains(curr) && !resultset.contains(curr)) {
				resultset.add(curr);
				result.add(s.substring(i - 9, i + 1));
			}
			else {
				set.add(curr);
			}
		}
		System.out.println(set);
		return result;
	}
}
