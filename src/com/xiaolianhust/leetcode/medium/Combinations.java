package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 3));
	}
	
	/**
	 * 第一种思路：
	 * 依然是之前递归+for的思路.
	 * 可能存在的问题：k比较大的时候，递归深度很大。导致效率和速度过慢。
	 * 首先还是把这个写出来把。
	 * 
	 * test1:6ms, 93.78%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 第二种思路：
	 * 纯粹的迭代实现，虽然有点难度，但是应该可行性还是有的，毕竟控制变量就是k。
	 * 难点就在于怎么控制形成有变量控制for层数
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] cache = new int[k];
        combinePath(result, k, n, cache, 0, 0);
        return result;
    }
    
    /**
     * 递归实现。
     * 
     * @param result 结果
     * @param k k值，这两个用于每轮的边界计算
     * @param n n值
     * @param cache 缓存数组保存
     * @param curr 当前层数
     * @param start 当前递归层次下的数值起始
     */
	private static void combinePath(List<List<Integer>> result, int k, int n, int[] cache, int curr, int start) {
		//基准情形
		if(curr == k) {
			List<Integer> oneAns = new ArrayList<>();
			for(int i = 0;i < k;++i)
				oneAns.add(cache[i]);
			result.add(oneAns);
			return;
		}
		
		//for循环遍历检测到所有的可能性
		for(int i = start;i <= n - k + curr; ++i) {
			cache[curr] = i + 1;
			combinePath(result, k, n, cache, curr + 1, i + 1);
		}
	}
    

    

}
