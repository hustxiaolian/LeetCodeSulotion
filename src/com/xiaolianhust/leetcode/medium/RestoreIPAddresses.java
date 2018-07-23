package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010"));
	}
	
	/**
	 * ��һ��˼·��
	 * Ϊ�˱���������п����ԣ��϶���ҪҪ��backtracking���ݷ���
	 * ��ô���ǱȽϾ�����ַ����ĵݹ���ݷ����ˡ�
	 * 
	 * bug:û�п��ǵ�010010����ɧ��·��
	 * 
	 * test2:2ms, beat 92.43%��=��=��=��(�b��b;)��
	 * @param s
	 * @return
	 */
	public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuffer cache = new StringBuffer();
        helper(s, result, cache, 0, 0, s.length());
        return result;
    }
	
	/**
	 * ÿһ�εݹ�����ҵ�һ�����ʵ��ֶΡ�
	 * �����ݹ����̿������鷳��ʵ�����Ҿ����߼����һ��Ƿֵú���ȷ�ġ�
	 * @param s
	 * @param result
	 * @param cache 
	 * @param i
	 * @param length
	 * @param n 
	 */
	private static void helper(String s, List<String> result, StringBuffer cache, int index, int iplayer, int n) {
		//��׼���Σ�������η���ж�
		int restChar = n - index, restLayer = 4 - iplayer;//�ֲ���ԭ�򣬱����ظ����㡣
		if(restChar > 3 * restLayer || restChar < restLayer)//�����κ�ʣ������֮���޷������ϵֱ��return
			return;
		//��׼���Σ�����ж����кܶ�ϸ�ڱ߽���жϡ�
		else if(iplayer == 3) {//�����趨Ϊ������Ҫ�Ƿ��㣬���Խ�Լһ����ʱ�䡣
			if(s.charAt(index) == '0' && restChar > 1)//����00x������
				return;
			int curr = Integer.valueOf(s.substring(index));
			if(0 <= curr && curr <= 255) {
				cache.append(curr);
				result.add(cache.toString());
			}
			return;
		}
		
		else if(s.charAt(index) == '0') {//�����ǰ���0��ͷ����ôֻ��ִ��һ�Ρ�
			int flag = cache.length();
			cache.append(0).append(".");
			helper(s, result, cache, index + 1, iplayer + 1, n);
			cache.delete(flag, cache.length());
			return;
		}
		
		//һ������
		for(int i = index;i < n && i < index + 3;++i) {
			String currsub = s.substring(index, i + 1);
			int curr = Integer.valueOf(currsub);
			if(0 <= curr && curr <= 255) {
				int flag = cache.length();
				cache.append(currsub).append(".");
				helper(s, result, cache, i + 1, iplayer + 1, n);
				cache.delete(flag, cache.length());
			}
		}
	}
	
}
