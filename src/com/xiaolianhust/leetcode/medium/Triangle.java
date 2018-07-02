package com.xiaolianhust.leetcode.medium;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ��һ��˼·��
	 * �����뷨����ÿ�ζ��ǿ��Լ��㵽��һ�����нڵ��ȫ��·���͵ģ��������ǰ����n�����֣���ô����һ��n������
	 * ����ײ��ֱ�ӱ���Ѱ����Сֵ���ɡ�
	 * ������һ����㵱ǰ���ǣ�curr[i] = last[i - 1] + last[i]
	 * 
	 * test1:6ms, beats 99.81%��=��=��=��(�b��b;)��
	 * 
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if(n == 1) return triangle.get(0).get(0);
        int[] cache = new int[n];
        cache[0] = triangle.get(0).get(0);
        //���µ���
        for(int i = 1;i < n;++i) {
        	List<Integer> currLevel = triangle.get(i);
        	cache[i] = currLevel.get(i) + cache[i - 1];
        	for(int j = i - 1;j > 0;--j) {
        		cache[j] = Math.min(cache[j], cache[j - 1]) + currLevel.get(j);
        	}
        	cache[0] = cache[0] + currLevel.get(0);
        }
        //��ȡ�����
        int result = cache[0];
        for(int i = 1;i < n;++i)
        	if(result > cache[i])
        		result = cache[i];
        
        return result;
    }
}
