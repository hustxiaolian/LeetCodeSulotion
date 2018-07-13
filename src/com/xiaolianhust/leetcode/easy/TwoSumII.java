package com.xiaolianhust.leetcode.easy;

public class TwoSumII {
	public static void main(String[] args) {
		System.out.println(twoSum(new int[] {2,7,11,15}, 9));
	}
	
	/**
	 * ��һ��˼·��
	 * ˫ָ�룬���������м��������ֹ����������ָ�����һ��.
	 * ÿ�ֵ�����������ָ��ָ��ֵ�ĺͣ��������target ,--right
	 * С��target��++left����������ҵ��ˣ�ֱ�ӷ��ء�
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
