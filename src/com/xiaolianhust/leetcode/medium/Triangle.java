package com.xiaolianhust.leetcode.medium;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 第一种思路：
	 * 核心想法：我每次都是可以计算到这一层所有节点的全部路径和的，即如果当前层有n个数字，那么就是一个n的数组
	 * 到达底层后，直接遍历寻找最小值即可。
	 * 根据上一层计算当前层是，curr[i] = last[i - 1] + last[i]
	 * 
	 * test1:6ms, beats 99.81%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if(n == 1) return triangle.get(0).get(0);
        int[] cache = new int[n];
        cache[0] = triangle.get(0).get(0);
        //向下迭代
        for(int i = 1;i < n;++i) {
        	List<Integer> currLevel = triangle.get(i);
        	cache[i] = currLevel.get(i) + cache[i - 1];
        	for(int j = i - 1;j > 0;--j) {
        		cache[j] = Math.min(cache[j], cache[j - 1]) + currLevel.get(j);
        	}
        	cache[0] = cache[0] + currLevel.get(0);
        }
        //获取最大结果
        int result = cache[0];
        for(int i = 1;i < n;++i)
        	if(result > cache[i])
        		result = cache[i];
        
        return result;
    }
}
