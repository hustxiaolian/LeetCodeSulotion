package com.xiaolianhust.leetcode.easy;

import java.util.PriorityQueue;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(thirdMax(new int[] {1}));
	}
	
	/**
	 * 思路：
	 * 使用三个变量依次储存最大，次大，次次大的数字，找到就推出即可。
	 * 相当于创建一个size=3的先进先出队列。而且这个队列还具有一定的排队功能。
	 * 
	 * 直接使用最小堆（优先队列）
	 * 
	 * test1: 5ms, beats 46.93%ε=ε=ε=┏(゜ロ゜;)┛
	 * 前排都是使用三个数字来完成这种思路的，各种if-else，麻烦而且不通用。
	 * 我应该是思路最简单的。简单直接。
	 * 
	 * 其实还想到一个思路，快速选择。但是他的一些特定需求，限定了使用。即小于3个数字时候，返回最大值。
	 * 
	 * @param nums
	 * @return
	 */
	public static int thirdMax(int[] nums) {
       PriorityQueue<Integer> queue = new PriorityQueue<>(3);
       int n = nums.length;
       int i;
       for(i = 0;i < n ;++i) {
    	   int curr = nums[i];
    	   if(!queue.contains(curr)) {
    		   queue.offer(curr);
    		   if(queue.size() == 3)
    			   break;
    	   }
       }
       
       for(;i < n;++i) {
    	   int curr = nums[i];
    	   if(curr > queue.peek() && !queue.contains(curr)) {
    		   queue.poll();
    		   queue.offer(curr);
    	   }
       }
       if(queue.size() == 2) {
    	   queue.poll();
    	   return queue.peek();
       }
       else
    	   return queue.peek();
    }
}
