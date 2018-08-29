package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
	}
	
	/**
	 * ������������⣺Find All Numbers Disappeared in an Array��
	 * ������ֵ����ӳ��Ļ���˼�룬������ô˼·�ͱȽϼ��ˡ�
	 * ����Ϊ��
	 * ���Ǳ�����������Ԫ�أ�nums[nums[i] - 1] = -nums[nums[i] - 1]���ǽ���ǰԪ��ӳ��������λ��
	 * �ĳɸ�ֵ����ʾ��Ԫ���Ѿ����ڣ������������Ԫ��ӳ��������жϣ�Ϊ��ֵ��˵��nums[i]�ظ��ˡ�
	 * 
	 * test1:12ms, beats 41.42%��=��=��=��(�b��b;)��
	 * ������ǰ�ţ�����һ�������ˣ���������ڴ��ٲ����ˣ�û��Ҫ��
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
