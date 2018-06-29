package com.xiaolianhust.leetcode.easy;

import java.util.HashSet;

public class SingleNumber {
	
	/**
	 * ��һ��˼·��
	 * ����map����setȥ�洢ÿ�����ֳ��ֵĴ�����Ȼ�������ɺ�ȥѰ�ҳ���һ�ε����֡�
	 * ����ʱ�䣬���Կռ䡣������ʵʵ��ʵ����
	 * test1��18ms, beats 19.47%��=��=��=��(�b��b;)��
	 * �Բۣ��������ף�ȫ������solution��ȫ�������ֱ�̬������
	 * ǰ�ŵĴ𰸻��Ǵ󲿷�Arrays.sort()֮��Ĵ𰸣��һ��ɱ�׼�����������������ܴﵽ���ԡ�
	 * 
	 * �ڶ���˼·��
	 * ��Ϊÿ�����ֶ�����ֳ������Σ�
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
	 * a^0 = a, a^a = 0, ����������㽻���ɺͽ���ɣ�
	 * ��˼·��ѧϰ�ˡ�
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
