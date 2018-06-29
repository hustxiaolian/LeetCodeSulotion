package com.xiaolianhust.leetcode.easy;

import java.util.HashSet;

public class SingleNumber {
	
	/**
	 * 第一种思路：
	 * 利用map或者set去存储每个数字出现的次数，然后遍历完成后，去寻找出现一次的数字。
	 * 线性时间，线性空间。先老老实实的实现下
	 * test1：18ms, beats 19.47%ε=ε=ε=┏(゜ロ゜;)┛
	 * 卧槽，这帮逼作弊，全部看了solution，全部是那种变态方法。
	 * 前排的答案还是大部分Arrays.sort()之后的答案，我怀疑标准库的排序对整数甚至能达到线性。
	 * 
	 * 第二种思路：
	 * 因为每个数字都会出现出现两次，
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	int tmp = nums[i];
        	if(set.contains(tmp))
        		set.remove(tmp);
        	else
        		set.add(tmp);
        }
        return (int) (set.toArray())[0];
    }
	
	/**
	 * a^0 = a, a^a = 0, 异或运行满足交换律和结合律，
	 * 神思路，学习了。
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result ^= i;
		}
		return result;
	}
}
