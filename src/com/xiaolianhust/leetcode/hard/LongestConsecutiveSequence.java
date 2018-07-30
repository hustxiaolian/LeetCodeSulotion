package com.xiaolianhust.leetcode.hard;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
	}
	
	/**
	 * 第一种思路：
	 * 1. 利用一个hashmap，其键值存储当前段区间下一个数字，然后检查，map中是否有该合并后的下一个数字，合并直到没有重复键
	 * 
	 * 我犯了一个错误，我没必要删除。区间中间的值，我只用保用它们的值是对的即可。
	 * 
	 * test1:9ms, beats 51.20%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 思路重新总结：
	 * 1. 区间边界的边界的键-值对必须表示正确，区间内部的键必须存在，因为需要防止重复出现。
	 * 2. 分情况讨论，统一编码。
	 * 2.1 如果插入的数字没重复，单独成一个区间， 即左和右都没有找到大佬区间。那么插入curr=1
	 * 2.2 如果插入的数字左边重复，即map.get(curr-1)有值，则，更新curr-left=sum
	 * 2.3 右边同理
	 * 2.4 两边都有大佬，那么就是2.2和2.3一起。
	 * 
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(!map.containsKey(curr)) {
        		int left = map.containsKey(curr - 1) ? map.get(curr - 1) : 0;
            	int right = map.containsKey(curr + 1) ? map.get(curr + 1) : 0;
            	//更新区间长度
            	int sum = left + right + 1;
            	result = Math.max(result, sum);
            	
            	map.put(curr, sum);//bug 1 如果两边都有大佬，该值没有插入到map，导致重复
            	
            	map.put(curr - left, sum);//更新左区间大佬的边界
            	map.put(curr + right, sum);//更新右大佬区间的边界
            	//这里如果该区间，只有一个人，那么更新自己两次
        	}
        	else
        		continue;//该数字已经计算过，那么什么也不错
        }
        return result;
    }
	
	public static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(!map.containsKey(curr)) {
        		if(map.containsKey(curr - 1)) {
        			
        		}
        	}
        	else
        		continue;//该数字已经计算过，那么什么也不错
        }
        return result;
    }
}
