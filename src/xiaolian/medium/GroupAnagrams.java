package xiaolian.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author 25040
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.

��ʾ���������⣬����������ͬ��ĵ��ʳ��ȱ�����һ�����ȡ�
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		groupAnagrams2(new String[] {"eat","tea","tan","ate","nat","bat"});
	}
	
	/**
	 * ��һ��˼·�����и��󵨵��뷨����������������ġ����ǰ����е��ַ�����һ����������ʾ��
	 * ���У�����뷨���ڴ󵨺ͼ����ˣ�ʹ��һ������Ϊ26����������ʾ��
	 * �Ƚ������ַ������Ƿ�����ͬһ���飬�����ж����Ƕ�Ӧ�������Ƿ���ȡ�
	 * ����˼·���裺
	 * 1. ��ʼ����������ʼ������ֵ��
	 * 2. ����ÿ���ַ��������ɵ�ǰ�ַ�����Ӧ���������Ȼ��ʹ��hash���ж��Ƿ�����ǰ����������Ƿ���ȡ�
	 * 3. ��ͬ���������ֱ���ڴ��в�������棬������Ǿʹ����µĽڵ㡣
	 * 
	 * ���˴𰸣����뵽��ʹ�ü����ķ�ʽ���жϣ��ҷ���֮��������ν��������hashmap������ֱ�ӽ���ת��Ϊ����Ԫ��ƴ�ӳ�һ��
	 * �ַ�������HashMap���������
	 * 
	 * ��ô˼·�ͺ������ˣ�
	 * 1. ��ʼ���𰸣��ж����������
	 * 2. ����ÿ���ַ��������ÿ���ַ��������ɶ�Ӧ�ļ������飬Ȼ��Ѽ�������Ԫ��ת��Ϊ�ַ�����
	 * 3. ʹ��������ַ�����ΪHashMap���������ж���ǰmap���Ƿ��У��������ѵ�ǰ�ַ������뵽map��Ӧ�����µ�list��
	 * 4. ��ɱ����󣬰�ÿ��list���뵽result�С�
	 * 
	 * test1:46ms, beats 15.18%
	 * 
	 * �����ֿ���ǰ�Ŵ��е��뷨��ȷʵʹ��StringBuffer���ַ�ʽ̫�˷�ʱ���ˡ��ĳɶ�char���������.
	 * ��ʵ��������һ�ַ���ֻ���ַ�����ÿ���ַ�������һ�飬���ԡ�����û�취��׼���sort����̫ǿ���ˡ�
	 * �ĳ����Լ���˼·������Stringbuffer�󣬸ĳ�String.valueof������Ч�������޴�
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if(strs.length == 0)  return result;
		char[] chars;
		String arrayStr;
		HashMap<String, List<String>> map = new HashMap<>();
		List<String> currList;
		for(String str : strs) {
			chars = str.toCharArray();
			char[] count = new char[26];
			for(char ch : chars) {
				count[ch - 'a']++;
			}
			arrayStr = String.valueOf(count);
			currList = map.get(arrayStr);
			if(currList == null) {
				currList = new ArrayList<>();
				map.put(arrayStr, currList);
				result.add(currList);
			}
			currList.add(str);
		}
		
		return result;
    }
	
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		if(strs.length == 0)  return result;
		char[] chars;
		String arrayStr;
		HashMap<String, List<String>> map = new HashMap<>();
		List<String> currList;
		for(String str : strs) {
			chars = str.toCharArray();
			int[] count = new int[26];
			StringBuffer sb = new StringBuffer();
			for(char ch : chars) {
				count[ch - 'a']++;
			}
			for(int num : count) {
				sb.append("#").append(num);
			}
			arrayStr = sb.toString();
			currList = map.get(arrayStr);
			if(currList == null) {
				currList = new ArrayList<>();
				map.put(arrayStr, currList);
				result.add(currList);
			}
			currList.add(str);
		}
		
		return result;
    }
}
