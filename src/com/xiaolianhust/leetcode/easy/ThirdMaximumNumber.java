package com.xiaolianhust.leetcode.easy;

import java.util.PriorityQueue;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(thirdMax(new int[] {1}));
	}
	
	/**
	 * ˼·��
	 * ʹ�������������δ�����󣬴δ󣬴δδ�����֣��ҵ����Ƴ����ɡ�
	 * �൱�ڴ���һ��size=3���Ƚ��ȳ����С�����������л�����һ�����Ŷӹ��ܡ�
	 * 
	 * ֱ��ʹ����С�ѣ����ȶ��У�
	 * 
	 * test1: 5ms, beats 46.93%��=��=��=��(�b��b;)��
	 * ǰ�Ŷ���ʹ�������������������˼·�ģ�����if-else���鷳���Ҳ�ͨ�á�
	 * ��Ӧ����˼·��򵥵ġ���ֱ�ӡ�
	 * 
	 * ��ʵ���뵽һ��˼·������ѡ�񡣵�������һЩ�ض������޶���ʹ�á���С��3������ʱ�򣬷������ֵ��
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
