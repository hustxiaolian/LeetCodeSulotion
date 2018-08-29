package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberDisappearedinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ��һ�֣�Ȼ��������һ����������ɼ�¼��
	 * 
	 * �ڶ���˼·������discuss�������һ�ֲ��ཻ�����˼�롣
	 * �������ֹ�����ô��������������ӳ���ԣ�ֱ���޸ġ�
	 * ����Ϊ��
	 * ������������У����ֹ����Ҿͽ�����ֵ��Ӧ��ӳ����и�ֵ�޸ģ�
	 * ��ô��ô�ڶ������ʱ������и�λ���ϻ�����ֵ����ô˵��û�м�����Ҳ����˵û����ֵ��Ӧ���������
	 * 
	 * test1: 9ms, beats 88.05%��=��=��=��(�b��b;)��
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
	 * �ʵ�����
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		int n = nums.length;
		for(int i = 0;i < n;++i) {
			int val = Math.abs(nums[i]) - 1;//����abs����������Ӧ������תΪ��ֵ����ôΪ�˻�ȡ��ȷ��������Ϣ��
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
