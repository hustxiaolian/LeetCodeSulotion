package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("aba", "baa"));
	}
	
	/**
	 * ˼·��
	 * ����hashMap��¼ÿ���ַ����ֵ�λ�ã�Ȼ�������ַ����ȶԡ�
	 * 
	 * test1: wrong answer,����֣������ĸ�testcase�Һ��ѱ��ز����¡�
	 * 
	 * �ο���discuss�����˶���ֱ��ʹ�����������㡣
	 * @param s
	 * @param t
	 * @return
	 */
	static HashMap<Character, List<Integer>> smap = new HashMap<>();
	static HashMap<Character, List<Integer>> tmap = new HashMap<>();
	public static boolean isIsomorphic(String s, String t) {
		smap.clear();
		tmap.clear();
		int n = s.length();
		for(int i = 0;i < n;++i) {
			char sch = s.charAt(i), tch = t.charAt(i);
			boolean sb = smap.containsKey(sch), tb = tmap.containsKey(tch);
			if(smap.containsKey(sch) && tmap.containsKey(tch)) {
				List<Integer> sl = smap.get(sch);
				List<Integer> tl = tmap.get(tch);
				if(sl.size() != tl.size())
					return false;
				else {
					int sn = sl.size();
					for(int j = 0;j < sn;++j) {
						if(sl.get(j) != tl.get(j))
							return false;
					}
				}
				sl.add(i);
				tl.add(i);
			}
			else if(!sb && !tb){
				List<Integer> newOne = new ArrayList<>();
				newOne.add(i);
				smap.put(s.charAt(i), newOne);
				
				newOne = new ArrayList<>();
				newOne.add(i);
				tmap.put(t.charAt(i), newOne);
			}
			else 
				return false;
		}
		
		return true;
        
    }
	
	/**
	 * �ܽᾭ�飬��ѵ���Ժ�������ֶ���ĸ��map�������Ͼͱ���Ҫ�뵽ʹ�����������棬
	 * ���ʹ�õ�����ĸ��Ϊkey����ɢ��hash����ȫû�б�Ҫ��ֱ��ʹ��128������Ϳ�����ȫ�������е��ַ�
	 * �ﵽ���ټ�¼�Ͳ�ѯ֮ǰ��Ϣ�Ĺ��ܡ�
	 * 
	 * test2:4ms, beats 87.63%��=��=��=��(�b��b;)��
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isIsomorphic2(String s, String t) {
		int[] m = new int[256];
		int sn = s.length();
		for(int i = 0;i < sn;++i) {
			char sch = s.charAt(i), tch = t.charAt(i);
			if(m[sch] != m[tch + 128]) return false;
			m[sch] = i + 1;
			m[tch + 128] = i + 1;
		}
		return true;
	}
}
