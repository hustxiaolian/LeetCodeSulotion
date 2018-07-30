package com.xiaolianhust.leetcode.hard;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
	}
	
	/**
	 * ��һ��˼·��
	 * 1. ����һ��hashmap�����ֵ�洢��ǰ��������һ�����֣�Ȼ���飬map���Ƿ��иúϲ������һ�����֣��ϲ�ֱ��û���ظ���
	 * 
	 * �ҷ���һ��������û��Ҫɾ���������м��ֵ����ֻ�ñ������ǵ�ֵ�ǶԵļ��ɡ�
	 * 
	 * test1:9ms, beats 51.20%��=��=��=��(�b��b;)��
	 * 
	 * ˼·�����ܽ᣺
	 * 1. ����߽�ı߽�ļ�-ֵ�Ա����ʾ��ȷ�������ڲ��ļ�������ڣ���Ϊ��Ҫ��ֹ�ظ����֡�
	 * 2. ��������ۣ�ͳһ���롣
	 * 2.1 ������������û�ظ���������һ�����䣬 ������Ҷ�û���ҵ��������䡣��ô����curr=1
	 * 2.2 ����������������ظ�����map.get(curr-1)��ֵ���򣬸���curr-left=sum
	 * 2.3 �ұ�ͬ��
	 * 2.4 ���߶��д��У���ô����2.2��2.3һ��
	 * 
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(!map.containsKey(curr)) {
        		int left = map.containsKey(curr - 1) ? map.get(curr - 1) : 0;
            	int right = map.containsKey(curr + 1) ? map.get(curr + 1) : 0;
            	//�������䳤��
            	int sum = left + right + 1;
            	result = Math.max(result, sum);
            	
            	map.put(curr, sum);//bug 1 ������߶��д��У���ֵû�в��뵽map�������ظ�
            	
            	map.put(curr - left, sum);//������������еı߽�
            	map.put(curr + right, sum);//�����Ҵ�������ı߽�
            	//������������䣬ֻ��һ���ˣ���ô�����Լ�����
        	}
        	else
        		continue;//�������Ѿ����������ôʲôҲ����
        }
        return result;
    }
	
	public static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;
        for(int i = 0;i < n;++i) {
        	int curr = nums[i];
        	if(!map.containsKey(curr)) {
        		if(map.containsKey(curr - 1)) {
        			
        		}
        	}
        	else
        		continue;//�������Ѿ����������ôʲôҲ����
        }
        return result;
    }
}
