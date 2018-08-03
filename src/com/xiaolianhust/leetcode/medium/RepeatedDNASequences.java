package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRepeatedDnaSequences2("GAGAGAGAGAG"));
	}
	/**
	 * ˼·��
	 * ������������Ŀ��˼�����޶������substringֻ��10�ĳ��ȡ�
	 * ���൱��һ�����ڣ����ǻ���������ڼ��ɡ�����hashset��¼ǰ����Ӵ�����������Ӵ��ȱȶԣ�Ȼ�����û������ӵ��µ��Ӵ�����
	 * 
	 * test1:31ms, beats 38.16%��=��=��=��(�b��b;)��
	 * 
	 * �ڶ��汾��
	 * ������ֻ��a,c,g,t�����ԣ���Ӵ��ڲ��������ƶ����ص㣬�����Լ�����hashcode���㣬��ɸ����ٶȵļ��㡣
	 * 
	 * test2:22ms, beats 95.97%��=��=��=��(�b��b;)��
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences(String s) {
		int n = s.length();
		HashSet<String> set = new HashSet<>();
		HashSet<String> result = new HashSet<>();
        for(int i = 10;i <= n;++i) {
        	String curr = s.substring(i - 10, i);
        	if(set.contains(curr)) {
        		result.add(curr);
        	}
        	else {
        		set.add(curr);
        	}
        }
        return new ArrayList<>(result);
    }
	
	static final int[] map2 = new int[10];
	static {
		map2[5] = 0;
		map2[7] = 1;
		map2[1] = 2;
		map2[4] = 3;
	}
	
	/**
	 * ������a��c��g��t��ascii��%10������������ͬ�����Խ���һ������ӳ�䣬Ȼ����仯Ϊ����bit��ʾ
	 * a-00
	 * c-01
	 * g-10
	 * t-11
	 * ʮ��ACGT�ַ���ɵ��ַ������Ϳ�����20��bit��ʾ��
	 * �µļ������������λ+������ɣ���ʡ�˼�������
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences2(String s){
		final int n = s.length();
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> resultset = new HashSet<>();
		List<String> result = new ArrayList<>();
		char[] sarr = s.toCharArray();
		int curr = 0, mask = ~((Integer.MIN_VALUE) >> 11);
		for(int i = 0;i < Math.min(10, n);++i) {
			char ch = sarr[i];
			int temp1 = ch % 10;
			int temp2 = map2[temp1];
			curr = (curr << 2) | temp2;
		}
		set.add(curr);
		for(int i = 10;i < n;++i) {
			curr = ((curr << 2) & mask) | map2[sarr[i] % 10];
			if(set.contains(curr) && !resultset.contains(curr)) {
				resultset.add(curr);
				result.add(s.substring(i - 9, i + 1));
			}
			else {
				set.add(curr);
			}
		}
		System.out.println(set);
		return result;
	}
}
