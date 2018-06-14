package com.xiaolian.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 
 * @author 25040
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *
 * 思路：
 * 1.最暴力的方式就是使用双重嵌套的方式直接暴力的一对对数字计算测试。
 * 时间复杂度就是：二次方，空间复杂度：常数
 * 
 * 2.使用哈希表完成线性的测试和检索。时间复杂度：线性，空间复杂度：二次方
 * 
 * @version 2.0 review了一下，基本是思路已经是最优化了。
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	/**
	 * 
	 * 思路2：
	 * 先把第一个元素放入哈希表中。
	 * 定义一个for循环，遍历以后的每个元素。对每一个元素都进行如下操作：
	 * 计算 target - arr[i]，然后判断计算结果是否在哈希表中。
	 * 
	 * 这样线性扫描一遍就知道有没有了。
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		//初始化各变量
		int[] result = new int[2];
		HashMap<Integer,Integer> m = new HashMap<>();
		int arrLength = nums.length;
		
		//把第一个元素放入集合中
		m.put(nums[0], 0);
		for(int i = 1; i < arrLength; ++i) {
			//计算欲求的值
			int temp = target - nums[i];
			//判断前面的数字是否有符合要求的
			if(m.containsKey(temp)) {
				//符合要求直接存储下标，返回结果。
				result[0] = m.get(temp);
				result[1] = i;
				break;
			}
			else {
				//把该元素放入map中
				m.put(nums[i], i);
			}
		}
		
		return result;
	}

}
