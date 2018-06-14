package com.xiaolianhust.leetcode.medium;

import java.util.HashMap;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * @author 25040
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ababababababababababababababababababab"
				+ "ababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababab"
				+ "abababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababa";
		String s = "babad";
		/*
		for(int i = 0;i < s.length();++i) {
			System.out.println(s.charAt(i));
		}
		
		System.out.println(s.substring(0,2));
		*/
		
		System.out.println(longestPalindromicSubstring2(s).length());
		System.out.println(s.length());
		System.out.println(s.substring(0, s.length()));
	}
	
	/**
	 * ˼·��
	 * 1.�������Ƿ����»������ַ���������
	 * 	a.�ڼ��ÿ���ַ�������һ��(aba)������(bb)���߶��(bbbbbbbb)
	 * 	b.����һ�����ȴ���1���ַ�����������ַ���������һ���ַ�����Ŀ���ڵ���2
	 * 
	 * ���裺
	 * 1. �����ַ�����ÿ���ַ������ҽ���hashSet�����ڴ洢�Ѿ�ɨ������ַ����ϡ�
	 * 2. ���������У�ֻҪ���ֵ�ǰ�ַ�����ɨ���ַ������ظ������Ǿͽ��л��ĵ��жϡ������ݴ����ַ�����
	 * 3. �ظ�����2��ֱ����ɨ�赽һ���ַ��������ܺ�ǰ����ִ��γ�һ������Ļ����ַ��������ǰѽ�����棬Ȼ�����hashSet����ɨ��
	 * 			�ַ���
	 * 
	 * һ���Ƚϴ�����⣬�������ݴ�һ��������Ҵ��������¿�ʼ������̡�
	 * 1.һ��ʵ�����ʵ��뷨���ҴӲ���2��һ�μ������ظ��ַ���ʱ��ʼ����Ϊ���ǰ���ַ��Ӽ�����ȫ���ظ�����ǰ�������ǻ��ġ�
	 * 	֮���Ի��������������Ϊ��С�������ַ���������һ����������Ļ������ַ����ص���
	 * 
	 * ���ˣ�˼·���60%�����ˣ���ʼ���룬�ڱ�����̽����Ҫע���ϸ�����⡣
	 * 
	 * bug 1 k Խ�������
	 * bug 2 �ٿ�����һ��������bab�������ظ���ʱ��
	 * bug 3 p_start < 0������Խ����ʴ���
	 * bug 4 ����if(s.charAt(p_start--) == s.charAt(p_end++)����������������Ƿ�������ᷢ���±���ƶ�
	 * bug 5 ������java�ĺ������úͲ�������ʱֵ���ݡ� 
	 * bug 6 �����ַ���ccc���������ԭ�����ڣ������㷨ʱ���ȼ���xxbbxx������ʽ�Ķ�����xbabx������ʽ��
	 * 			���������������ǰ���и�����Ǳ��������˵����������Ҫ����һ�����һ��
	 * bug 7 string���subString��begin��end��û����ȫ��ȡ���һ���ַ���
	 * bug 8 ���aaaaaa��ʱ��ģ����㷨���ǻ�ɾ����ǰ��һ�㣬
	 * bug 9 ���е�������ʽ�Ҿ�Ȼûע�⵽��aba�ȶԵĻ���bab���������ڳ����������ǲ�һ����
	 * 
	 * �Ľ�1������bug 7 ���Ҷ�subStringû��˵����ƾ���ܲ��ˡ�
	 * 
	 * ʱ�临�Ӷȣ�������Ρ���ȫֻ��һ���ַ�aaaaaaaaaaaaaaaa,�������ǵö��ε�ʱ�临�Ӷȣ�
	 * 				����˵ababababab�����߶��ظ������γɺܶ�����ִ�����ô�ҵ��㷨���ÿ�����ܷ��Ķ��жϣ�����ڱ������η��ķ���
	 * 				��ʡ������ʱ��Ƚ��١�
	 * �ռ临�Ӷȣ�����
	 * 
	 * test1: 118ms, beats(26.03%)(Ц������=��=��=��(�b��b;)��)
	 * @param s
	 * @return
	 */
	public static String longestPalindromicSubstring1(String s) {
		//��ʼ��������
		//String subStr = s.substring(0, 1);
		String result = s.substring(0, 1);
		//����ֻ�����߾ȹ��£��Ҳ�֪��Ϊʲôû��char�İ�װ�ࡣ����ʹ��string��codePointAt�����������ظ���
		HashMap<Integer,Integer> set = new HashMap<>(); 
		int len = s.length();
		int p_start = 0;
		int p_end = 0;
		int i = 0;
		 
		//����ÿ���ַ���ÿ���ַ�
		while(i < len) {
			int currentCharCodePoint = s.codePointAt(i);
			//�����жϵ�ǰ�ַ��Ƿ�������ظ�
			if(set.containsKey(currentCharCodePoint)) {
				//�ó����ظ��ˣ��ֿ��Է�Ϊ���������
				//1.��һ���ַ��ļ�������γɸ����Ļ���
				//2.��һ���ַ��ļ��벻�����γɻ���
				
				//�ж��ظ����ַ��Ƿ��ǽ��ڵģ���xabax����ʽ
				if(p_start - 1 >= 0 && s.charAt(p_start - 1) == s.charAt(p_end)) {
					//bab���������Ҳ����Ҫ��
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start - 1, p_end);
				}
				if(p_end + 1 < s.length() && s.charAt(p_start) == s.charAt(p_end + 1)) {
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start, p_end + 1);
				}
				//�жϻ�����ʽ�Ƿ�Ϊxxxbbxxx������ʽ
				if(s.charAt(p_start) == s.charAt(p_end)) {
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start, p_end);
				}
				//�жϻ�����ʽΪbab
				
				
				//������ǣ���˵�����޷��γɻ��ģ�������������Ҫ������ǰ�漯���� ��ǰ�ظ���ĸ֮ǰ����Щ�ַ�
				//��Ȼ���������Ѿ�����˼���������ȡ��һ�����ģ�����ͬ����Ҫ����һ����
				//��Ϊ������û���γɻ���
				//���Ȼ�ȡ�Ǹ��ظ����ַ�������
				int k = set.get(currentCharCodePoint);
				//Ȼ����ǰһ·ɾ��
				while(k >= 0 && set.containsKey(s.codePointAt(k))) {
					set.remove(s.codePointAt(k));
					--k;
				}
				
			}
			//���û����˵��ǰ����ַ�����һ�㶼û���ظ�,��ӵ������У�������һ��,����������pָʾ�á�
			set.put(currentCharCodePoint,i);
			p_start = i++;
			p_end = i;
		}
		
		return result;
	}
	
	/**
	 * ����ȷ����ǰ���ĵ��������������������ǰ״̬������ġ�
	 * ���������ı�result�ݴ�ĸ��������滻��������ԭ���ķ���
	 * ʱ�临�Ӷ������ԡ��ռ临�Ӷ�Ҳ�����ԡ�
	 * @param s
	 * @param result
	 * @param p_start
	 * @param p_end
	 * @return
	 */
	public static String pailindromicCheckAndSaveLongerSubstring(String s, String result, int p_start, int p_end) {
		String subStr;

		//����ǣ�˵����������γ�һ���������ȵĻ��ġ�xxbbxxx
		//��ѭ���൱��һ�����ļ�����ȥ���������ĵ������߽�
		while(p_start >= 0 && p_end < s.length() && s.charAt(p_start) == s.charAt(p_end)) {
			p_start--;
			p_end++;
		}
		//bug 7 string���subString��begin��end��û����ȫ��ȡ���һ���ַ�������ֻ�������ˡ�
		
		subStr = s.substring(p_start + 1, p_end);
	
		//�����������ַ����ĳ��ȸ�������ô�滻���
		if(subStr.length() > result.length()) {
			System.out.println("����λ��"+ p_start + "," + p_end);
			//System.out.println(subStr);
			result = subStr;
		}
		//֮�󣬴������һ���ظ��ĵط�������ʼ��ѭ����
		return result;
	}
	
	/**
	 * �����review�����¹��������20���⣬���Ҷ����ǽ��з��࣬�Ա����Ժ�ϰ��������ߡ�
	 * ��ε�˼·����solution�Ǹ��������˼·��
	 * ����Ϊ��
	 * 1. ָ��һ����ĸ���ã������������ַ�����ÿ����ĸ��
	 * 2. ���ÿ��ָ������ĸ����������Ϊ������������չ��
	 * 		(ע���������������һ���Ը���ĸ�����ĶԳƣ�һ���ǰ�������ĸ�ľ���Գ�)
	 * @param s
	 * @return
	 */
	public static String longestPalindromicSubstring2(String s) {
		String result = "";
		int n = s.length();
		
		for(int i = 0;i < n - 1; ++i) {
			String result1 = judge(s, i, i + 1, n);
			String result2 = judge(s, i - 1, i + 1, n);
			String max = result1.length() > result2.length() ? result1 : result2;
			result = max.length() > result.length() ? max : result;
		}
		
		return result;
	}
	
	private static String judge(String s, int left, int right, int length) {
		while(left > 0 && right < length && s.charAt(left--) == s.charAt(right++));
		left = left < 0? 0: left;
		right = right > length ? length : right;
		return s.substring(left, right);
	}
}
