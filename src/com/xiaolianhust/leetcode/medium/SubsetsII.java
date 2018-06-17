package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetsWithDup(new int[] {1,2,2}));
	}
	
	/**
	 * ��һ��˼·��
	 * ����˼·����subset��for+�ݹ����ס��ؼ�������ж��ظ���������󣬵�ǰ�ִ�(��ǰcurrλ��)�����в�Ҫ��
	 * ������ͬ��
	 * 
	 * ����˼·��
	 * 1. ��ʼ������������������������Ұɿռ���ӵ������
	 * 2. ����ݹ顣�ߵݹ����ӽ����
	 * 
	 * test1:5ms, beats 71.73%��=��=��=��(�b��b;)��
	 * ���У��ҵ�����˼·�ǳ��򵥡�
	 * 
	 * �Ľ���ʹ��ArrayList���ԸĽ�addOneAns������裬��Ϊ����ֱ�Ӱ�cache�ѹ���������롣
	 * ��Ȼ�ٶ���û�����������Ǹ��Ӿ���
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        result.add(new ArrayList<>());
        if(n == 0) return result;
        Arrays.sort(nums);
        ArrayList<Integer> cache = new ArrayList<>();
        subsetRecursion(result,cache, nums, 0, n, 0);
        return result;
    }
	/**
	 * ����˼�룺�жϵ�ǰλ�����Ƿ�����ֵ�������ͬ����ͬ��ô�������ظ��ģ�û�����壬ֱ��������
	 * @param result
	 * @param cache
	 * @param nums 
	 * @param i
	 * @param n
	 * @param j
	 */
	private static void subsetRecursion(List<List<Integer>> result, ArrayList<Integer> cache, int[] nums, int startIndex, int n, int curr) {
		for(int i = startIndex;i < n;++i) {
			if(i > startIndex && nums[i] == nums[i - 1])//����startindex����˵�������ֿ��Ժ�ǰ����ͬ��
				continue;
			cache.add(nums[i]);
			result.add(new ArrayList<>(cache));
			subsetRecursion(result, cache, nums, i + 1, n, curr + 1);
			cache.remove(curr);
		}
	}
	

}
