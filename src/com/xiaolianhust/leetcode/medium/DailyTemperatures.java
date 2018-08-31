package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(dailyTemperatures2(new int[] {1,1,1,1,5,6,1,8})));
	}
	
	/**
	 * 思路：
	 * 其核心思想就是利用堆栈，将下降沿的数值先存储起来，等待气温回升。
	 * 
	 * 总结思考：
	 * stack堆栈实战理解：堆栈其实就是一种，当前事情必须暂时放下，我先去做其他事情，回头再来干。
	 * 依次等其他事情做完 了，条件适合我现在做事了再出来。
	 * 
	 * 针对这道题而言，就是说，如果将每天的温度压进堆栈，等待温度超过我的时候停下。
	 * 如果今天比昨天大，那么立马就被pop了，如果这几天都没有温度比我大，那么就一直压在堆栈中等到大佬。
	 * 
	 * 从上面的规律可以看出，stack中从顶到底是从小到大的顺序。
	 * 
	 * test1: 76ms, beats 30.82%ε=ε=ε=┏(゜ロ゜;)┛
	 * test2: 63ms, beats 52.71% ε=ε=ε=┏(゜ロ゜;)┛
	 * 我看下前排大佬怎么做的。这么快。前排的大佬都是使用自己创建的array堆栈。
	 * 
	 * 
	 * test3: 9ms, beats 93.36% ε=ε=ε=┏(゜ロ゜;)┛
	 * 我日，这么快。看来以后如果在做这类题目的时候，考虑使用自己创建的数组堆栈，是真的快。
	 * 个人觉得，主要是它一开始就创建了足够大的空间，因此不会在运行时重新需要分配空间，妙。
	 * @param temperatures
	 * @return
	 */
	public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        stack.push(0);
        for(int i = 1;i < n;++i) {
        	while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        		int temp = stack.pop();
        		result[temp] = i - temp;
        	} 
        	stack.push(i);
        }
        //对了，这一段完全不需要，因为java初始化为0
        /*
        while(!stack.isEmpty()) {
        	result[stack.pop()] = 0;
        }
        */
        return result;
    }
	
	public static int[] dailyTemperatures2(int[] temperatures) {
		int n = temperatures.length;
		int[] result = new int[n];
		if(n < 2) return result;
		int[] stack = new int[n];
		int idx = -1;
		stack[++idx] = 0;
		
		for(int i = 1;i < n;++i) {
			int curr = temperatures[i];
			while(idx >= 0 && curr > temperatures[stack[idx]]) {
				int temp = stack[idx--];
				result[temp] = i - temp;
			}
			stack[++idx] = i;
		}
		return result;
	}
}
