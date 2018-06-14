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
 * ˼·��
 * 1.����ķ�ʽ����ʹ��˫��Ƕ�׵ķ�ʽֱ�ӱ�����һ�Զ����ּ�����ԡ�
 * ʱ�临�ӶȾ��ǣ����η����ռ临�Ӷȣ�����
 * 
 * 2.ʹ�ù�ϣ��������ԵĲ��Ժͼ�����ʱ�临�Ӷȣ����ԣ��ռ临�Ӷȣ����η�
 * 
 * @version 2.0 review��һ�£�������˼·�Ѿ������Ż��ˡ�
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	/**
	 * 
	 * ˼·2��
	 * �Ȱѵ�һ��Ԫ�ط����ϣ���С�
	 * ����һ��forѭ���������Ժ��ÿ��Ԫ�ء���ÿһ��Ԫ�ض��������²�����
	 * ���� target - arr[i]��Ȼ���жϼ������Ƿ��ڹ�ϣ���С�
	 * 
	 * ��������ɨ��һ���֪����û���ˡ�
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		//��ʼ��������
		int[] result = new int[2];
		HashMap<Integer,Integer> m = new HashMap<>();
		int arrLength = nums.length;
		
		//�ѵ�һ��Ԫ�ط��뼯����
		m.put(nums[0], 0);
		for(int i = 1; i < arrLength; ++i) {
			//���������ֵ
			int temp = target - nums[i];
			//�ж�ǰ��������Ƿ��з���Ҫ���
			if(m.containsKey(temp)) {
				//����Ҫ��ֱ�Ӵ洢�±꣬���ؽ����
				result[0] = m.get(temp);
				result[1] = i;
				break;
			}
			else {
				//�Ѹ�Ԫ�ط���map��
				m.put(nums[i], i);
			}
		}
		
		return result;
	}

}
