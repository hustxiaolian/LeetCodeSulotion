package com.xiaolianhust.leetcode.easy;

public class TwoSumII {
	public static void main(String[] args) {
		System.out.println(twoSum(new int[] {2,7,11,15}, 9));
	}
	
	/**
	 * 第一种思路：
	 * 双指针，从两端向中间遍历，终止条件是两个指针合在一起.
	 * 每轮迭代计算两个指针指向值的和，如果大于target ,--right
	 * 小于target，++left，否则就是找到了，直接返回。
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        int left = 0, right = n -1;
        while(left < right) {
        	int sum = numbers[left] + numbers[right];
        	if(sum > target)
        		--right;
        	else if(sum < target)
        		++left;
        	else {
        		result[0] = left + 1;
        		result[1] = right + 1;
        		break;
        	}
        }
        return result;
    }

}
