package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010"));
	}
	
	/**
	 * 第一种思路：
	 * 为了遍历，穷尽所有可能性，肯定是要要用backtracking回溯法。
	 * 那么就是比较经典的字符串的递归回溯方法了。
	 * 
	 * bug:没有考虑到010010这种骚套路。
	 * 
	 * test2:2ms, beat 92.43%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param s
	 * @return
	 */
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuffer cache = new StringBuffer();
        helper(s, result, cache, 0, 0, s.length());
        return result;
    }
	
	/**
	 * 每一次递归就是找到一个合适的字段。
	 * 整个递归例程看起来麻烦，实际上我觉得逻辑上我还是分得很明确的。
	 * @param s
	 * @param result
	 * @param cache 
	 * @param i
	 * @param length
	 * @param n 
	 */
	private static void helper(String s, List<String> result, StringBuffer cache, int index, int iplayer, int n) {
		//基准情形，避免无畏的判断
		int restChar = n - index, restLayer = 4 - iplayer;//局部性原则，避免重复计算。
		if(restChar > 3 * restLayer || restChar < restLayer)//如果层次和剩余数量之间无法满足关系直接return
			return;
		//基准情形，这个判断中有很多细节边界的判断。
		else if(iplayer == 3) {//这里设定为三层主要是方便，可以节约一部分时间。
			if(s.charAt(index) == '0' && restChar > 1)//最后防00x这样的
				return;
			int curr = Integer.valueOf(s.substring(index));
			if(0 <= curr && curr <= 255) {
				cache.append(curr);
				result.add(cache.toString());
			}
			return;
		}
		
		else if(s.charAt(index) == '0') {//如果当前层次0开头，那么只用执行一次。
			int flag = cache.length();
			cache.append(0).append(".");
			helper(s, result, cache, index + 1, iplayer + 1, n);
			cache.delete(flag, cache.length());
			return;
		}
		
		//一般情形
		for(int i = index;i < n && i < index + 3;++i) {
			String currsub = s.substring(index, i + 1);
			int curr = Integer.valueOf(currsub);
			if(0 <= curr && curr <= 255) {
				int flag = cache.length();
				cache.append(currsub).append(".");
				helper(s, result, cache, i + 1, iplayer + 1, n);
				cache.delete(flag, cache.length());
			}
		}
	}
	
}
