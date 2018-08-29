package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
	}
	
	/**
	 * 借鉴其类似问题：Find All Numbers Disappeared in an Array中
	 * 数组数值二次映射的基本思想，我们那么思路就比较简单了。
	 * 具体为：
	 * 我们遍历整个数组元素，nums[nums[i] - 1] = -nums[nums[i] - 1]我们将当前元素映射索引的位置
	 * 改成负值，表示该元素已经存在，后续如果还有元素映射过来，判断，为负值，说明nums[i]重复了。
	 * 
	 * test1:12ms, beats 41.42%ε=ε=ε=┏(゜ロ゜;)┛
	 * 看了下前排，代码一样。算了，懒得清空内存再测试了，没必要。
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	int val = Math.abs(nums[i]) - 1;
        	if(nums[val] > 0)
        		nums[val] = -nums[val];
        	else
        		result.add(val + 1);
        }
        return result;
    }
}
