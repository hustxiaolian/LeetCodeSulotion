package com.xiaolianhust.leetcode.easy;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(4));
	}
	
	/**
	 * 第一个思路：
	 * 递归+for，跟前面的思路很像，而且也没有去重这种麻烦事.
	 * 
	 * 思路是正确的，但是同理，它time executed out超时了。
	 * 原因，这么递归确实是慢，而且无效。主要在于有大量重复的计算
	 * 
	 * 
	 * 第二个思路：
	 * 仔细琢磨下，其实这我感觉是一个排列组合的问题
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	return path(0, n, 0);
    }

	private static int path(int curr, int end, int cnt) {
		if(curr == end)
			return 1;
		int temp = 0;
		if(curr < end)
			temp = path(curr + 1, end, cnt);
		if(curr + 1 < end)
			temp += path(curr + 2, end, cnt);
		return temp;
	}
    
	/**
	 * 第二个思路：
	 * 上面那个的问题就是大量无用的计算，浪费时间。
	 * 因此，可以使用一个数组去记录。
	 * @param n
	 * @return
	 */
	public static int climbStairs2(int n) {
		int[] mem = new int[n];
		return path2(0, n, mem);
	}

	private static int path2(int i, int n, int[] mem) {
		//基准情形
		if(i > n)
			return 0;
		if(i == n)
			return 1;
		if(mem[i] > 0)
			return mem[i];
		mem[i] = path2(i + 1, n, mem) + path2(i + 2, n, mem);
		return mem[i];
	}
	
	/**
	 * 第三个思路：（借鉴了答案的思路，这道题的难点就在于必须要看穿这种他们前后之间这种关系）
	 * 动态规划，其实仔细理解题目，其实我们可以发现：
	 * d[p] = d[p - 1] + d[p - 2]
	 * 为什么会这样呢？我们仔细理解题目，可以发现，
	 * 达到p层的来源，只有可能是两个，一个是p - 1层上迈出一个，一个是p - 2层上迈出2步。
	 * 那有人可能会问？那为什么没有在p - 2层上先1步再1步的方式呢，因为它就是p - 1层上迈出一个这种，一样的。
	 * 
	 * test1:4ms, beast 98.62%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param n
	 * @return
	 */
	public static int climbStairs3(int n) {
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		
		int first = 1, second = 2;
		int result = 0;
		for(int i = 3;i <= n;++i) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	} 

}
