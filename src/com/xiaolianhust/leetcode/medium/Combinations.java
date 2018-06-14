package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 3));
	}
	
	/**
	 * ��һ��˼·��
	 * ��Ȼ��֮ǰ�ݹ�+for��˼·.
	 * ���ܴ��ڵ����⣺k�Ƚϴ��ʱ�򣬵ݹ���Ⱥܴ󡣵���Ч�ʺ��ٶȹ�����
	 * ���Ȼ��ǰ����д�����ѡ�
	 * 
	 * test1:6ms, 93.78%��=��=��=��(�b��b;)��
	 * 
	 * �ڶ���˼·��
	 * ����ĵ���ʵ�֣���Ȼ�е��Ѷȣ�����Ӧ�ÿ����Ի����еģ��Ͼ����Ʊ�������k��
	 * �ѵ��������ô�����γ��б�������for����
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] cache = new int[k];
        combinePath(result, k, n, cache, 0, 0);
        return result;
    }
    
    /**
     * �ݹ�ʵ�֡�
     * 
     * @param result ���
     * @param k kֵ������������ÿ�ֵı߽����
     * @param n nֵ
     * @param cache �������鱣��
     * @param curr ��ǰ����
     * @param start ��ǰ�ݹ����µ���ֵ��ʼ
     */
	private static void combinePath(List<List<Integer>> result, int k, int n, int[] cache, int curr, int start) {
		//��׼����
		if(curr == k) {
			List<Integer> oneAns = new ArrayList<>();
			for(int i = 0;i < k;++i)
				oneAns.add(cache[i]);
			result.add(oneAns);
			return;
		}
		
		//forѭ��������⵽���еĿ�����
		for(int i = start;i <= n - k + curr; ++i) {
			cache[curr] = i + 1;
			combinePath(result, k, n, cache, curr + 1, i + 1);
		}
	}
    

    

}
