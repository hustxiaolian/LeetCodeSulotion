package com.xiaolianhust.leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		
		System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
	}
	
	/**
	 * 这道题的思路其实和PathSum有点像，只是本题是一个维度上的，而那道题是树，两个维度上的。
	 * 思路：
	 * 在每个节点上根据下面的公式来判断，我们使用prefix来记录前面和值，并且记录在hashmap中，每个节点都更新。
	 * 而target就是我们想要求得的值，currSum就是从头到尾的和。
	 * prefix sum + target = currSum。
	 * 
	 * test1: 27ms.
	 * 
	 * 总结，这种思路真的要好好熟悉和记住，这点和求链表的倒数第K个节点。但也不完全像。
	 * 总结：
	 * 也就是说，我要求中间的部分是一个恒定值时，我们可以使用从头到尾的all-prefix来判断。
	 * 谢谢。
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
        int currAllSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int n = nums.length;
        map.put(0, 1);
        for(int i = 0;i < n;++i) {
        	int currVal = nums[i];
        	currAllSum += currVal;
        	
        	if(map.containsKey(currAllSum - k)) {
        		result += map.get(currAllSum - k);
        	}
        	if(!map.containsKey(currAllSum)) {
    			map.put(currAllSum, 1);
    		} else {
    			map.put(currAllSum, map.get(currAllSum) + 1);
    		}
        }
        return result;
    }
}
