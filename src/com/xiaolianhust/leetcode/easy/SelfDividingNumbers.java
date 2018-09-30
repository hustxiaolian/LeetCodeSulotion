package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(selfDividingNumbers(162,168));
	}
	
	/**
	 * 思路：
	 * 最简单，粗暴的思路就是遍历。
	 * 另外，值得关注的是，如果要求，形成当前数字的每个位，都是他的分解因子之一。
	 * 例如128中，1 2 8 都是其因子的一份，也就是说128%（1*2*8 ）==0
	 * @param left
	 * @param right
	 * @return
	 */
	public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left;i <= right; ++i) {
        	if(i % 10 == 0) continue;
        	int j;
        	for(j = i;j > 0;j /= 10) {
        		int d = j % 10;
        		if(d == 0 || i % d != 0) break;
        	}
        	if(j == 0)
        		res.add(i);
        }
        return res;
    }
}
