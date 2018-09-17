package com.xiaolianhust.leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		
		System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
	}
	
	/**
	 * ������˼·��ʵ��PathSum�е���ֻ�Ǳ�����һ��ά���ϵģ����ǵ�������������ά���ϵġ�
	 * ˼·��
	 * ��ÿ���ڵ��ϸ�������Ĺ�ʽ���жϣ�����ʹ��prefix����¼ǰ���ֵ�����Ҽ�¼��hashmap�У�ÿ���ڵ㶼���¡�
	 * ��target����������Ҫ��õ�ֵ��currSum���Ǵ�ͷ��β�ĺ͡�
	 * prefix sum + target = currSum��
	 * 
	 * test1: 27ms.
	 * 
	 * �ܽᣬ����˼·���Ҫ�ú���Ϥ�ͼ�ס������������ĵ�����K���ڵ㡣��Ҳ����ȫ��
	 * �ܽ᣺
	 * Ҳ����˵����Ҫ���м�Ĳ�����һ���㶨ֵʱ�����ǿ���ʹ�ô�ͷ��β��all-prefix���жϡ�
	 * лл��
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
        int currAllSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int n = nums.length;
        map.put(0, 1);
        for(int i = 0;i < n;++i) {
        	int currVal = nums[i];
        	currAllSum += currVal;
        	
        	if(map.containsKey(currAllSum - k)) {
        		result += map.get(currAllSum - k);
        	}
        	if(!map.containsKey(currAllSum)) {
    			map.put(currAllSum, 1);
    		} else {
    			map.put(currAllSum, map.get(currAllSum) + 1);
    		}
        }
        return result;
    }
}
