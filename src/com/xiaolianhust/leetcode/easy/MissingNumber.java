package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(missingNumber3(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	
	/**
	 * ˼·��
	 * ��һ�ּ򵥴ֱ��ķ�����
	 * ֱ�������жϾ������ˡ�
	 * 
	 * test1: 10ms, beats 10.93%��=��=��=��(�b��b;)��
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
        for(int i = 0;i < n;++i)
        	if(nums[i] != i)
        		return i;
        return n;
    }
	
	/**
	 * �ڶ���˼·��
	 * ʹ��hashset���洢��Ȼ�������顣
	 * @param nums
	 * @return
	 */
	public static int missingNumber2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int num : nums)
			set.add(num);
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			if(nums[i] != i)
				return i;
		}
		return n;
	}
	
	/**
	 * ������˼·��
	 * ʹ��bit������ʹ��xor����������ɡ�
	 * 
	 * test2:1ms, beat 52.54% ��=��=��=��(�b��b;)��
	 * @param nums
	 * @return
	 */
	public static int missingNumber3(int[] nums) {
		int missNum = nums.length;
		int n = missNum;
		for(int i = 0;i < n; ++i)
			missNum ^= (i ^ nums[i]);
		return missNum;
	}
}
