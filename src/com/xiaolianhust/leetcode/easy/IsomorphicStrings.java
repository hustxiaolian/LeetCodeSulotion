package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("aba", "baa"));
	}
	
	/**
	 * 思路：
	 * 利用hashMap记录每个字符出现的位置，然后两个字符相会比对。
	 * 
	 * test1: wrong answer,很奇怪，但是哪个testcase我很难本地测试下。
	 * 
	 * 参考了discuss，别人都是直接使用数组来计算。
	 * @param s
	 * @param t
	 * @return
	 */
	static HashMap<Character, List<Integer>> smap = new HashMap<>();
	static HashMap<Character, List<Integer>> tmap = new HashMap<>();
	public static boolean isIsomorphic(String s, String t) {
		smap.clear();
		tmap.clear();
		int n = s.length();
		for(int i = 0;i < n;++i) {
			char sch = s.charAt(i), tch = t.charAt(i);
			boolean sb = smap.containsKey(sch), tb = tmap.containsKey(tch);
			if(smap.containsKey(sch) && tmap.containsKey(tch)) {
				List<Integer> sl = smap.get(sch);
				List<Integer> tl = tmap.get(tch);
				if(sl.size() != tl.size())
					return false;
				else {
					int sn = sl.size();
					for(int j = 0;j < sn;++j) {
						if(sl.get(j) != tl.get(j))
							return false;
					}
				}
				sl.add(i);
				tl.add(i);
			}
			else if(!sb && !tb){
				List<Integer> newOne = new ArrayList<>();
				newOne.add(i);
				smap.put(s.charAt(i), newOne);
				
				newOne = new ArrayList<>();
				newOne.add(i);
				tmap.put(t.charAt(i), newOne);
			}
			else 
				return false;
		}
		
		return true;
        
    }
	
	/**
	 * 总结经验，教训，以后见到这种对字母的map，基本上就必须要想到使用数组来代替，
	 * 如果使用单个字母作为key，在散列hash，完全没有必要，直接使用128的数组就可以完全覆盖所有的字符
	 * 达到快速记录和查询之前信息的功能。
	 * 
	 * test2:4ms, beats 87.63%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isIsomorphic2(String s, String t) {
		int[] m = new int[256];
		int sn = s.length();
		for(int i = 0;i < sn;++i) {
			char sch = s.charAt(i), tch = t.charAt(i);
			if(m[sch] != m[tch + 128]) return false;
			m[sch] = i + 1;
			m[tch + 128] = i + 1;
		}
		return true;
	}
}
