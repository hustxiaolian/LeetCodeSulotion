package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 第一种，然后是适用一个数组来完成记录。
	 * 
	 * 第二种思路，看了discuss，借鉴了一种不相交集类的思想。
	 * 如果你出现过，那么利用数组索引的映射性，直接修改。
	 * 具体为：
	 * 如果你在数组中，出现过，我就将你数值对应的映射进行负值修改，
	 * 那么那么第二遍遍历时，如果有个位置上还是正值，那么说明没有见过，也就是说没有数值对应这个索引。
	 * 
	 * test1: 9ms, beats 88.05%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] app = new boolean[nums.length];
        for(int i = 0;i < nums.length;++i) {
        	app[nums[i] - 1] = true;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < nums.length;++i) {
        	if(!app[i])
        		result.add(i + 1);
        }
        return result;
    }
	
	/**
	 * 妙，实在是妙。
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			int val = Math.abs(nums[i]) - 1;//这里abs，就是我们应将它反转为负值，那么为了获取正确的索引信息，
			if(nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}
		List<Integer> result = new ArrayList<>();
		for(int i = 0;i < n;++i) {
			if(nums[i] > 0)
				result.add(i + 1);
		}
		return result;
	}
}
