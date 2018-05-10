package xiaolian.medium;

import java.util.HashMap;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author 25040
 *
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring2("pwwkew"));
	}
	
	/**
	 * idea:ʹ��hashset�����ζ�ȡÿ���ַ����жϸ��ַ��Ƿ������hashset�У��ɴ����ж��ظ���
	 * 1. ����ظ��ˣ���¼��ʱ�ĳ���,��¼��ʱhashset����ֵ���Ƕ�Ӧ�ĳ��ȡ�Ȼ�������ӵ�ǰi����ǰ�ƶ���i--������ɾ��hashset�е��ظ��ַ���ֱ��ǰ���ظ����ַ�Ϊֹ��
	 * 2. ������ַ�û���ظ�����ô�ͽ������뵽set�У�
	 * 
	 * ʱ�临�Ӷȣ�2n,ÿ���ַ���౻���������飬���ҵ��ù��̵Ŀ�ܺ������ñȽ϶ࡣ
	 * �ռ临�Ӷȣ�m���ԣ��Ǹ�����Ҳ����ȥ��ʹ��charAt����������
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring1(String s) {
		HashMap<Character, Integer> set = new HashMap<>();
		char[] charArray = s.toCharArray();
		int result = 0;
		
		for(int i = 0;i < charArray.length; ++i) {
			char ch = charArray[i];
			if(set.containsKey(ch)) {
				if(set.size() > result) {
					result = set.size();
				}
				for(int j = set.replace(ch, i) - 1;j >= 0 && set.remove(charArray[j], j);j--);//��ǰ���ظ��ַ���ʼɾ��֮ǰ��
			}
			else 
				set.put(ch, i);
		}
		if(set.size() > result)
			result = set.size();
		
		return result;
    }
	
	/**
	 * ���ַ�������ο��˴�֮��д�����ġ�������Ҳʹ����map����û�뵽��һ�㡣Ҫѧϰ�ĵط����кܶడ��
	 * ʱ����ޣ����ԡ�����ֻ������һ�顣
	 * �ռ���ޣ����ԣ���Ϊmap�Ĵ���
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring2(String s) {
		HashMap<Character, Integer> set = new HashMap<>();
		char[] charArray = s.toCharArray();
		int result = 0;
		int i = 0,j = -1;
		
		for(;i < charArray.length; ++i) {
			char ch = charArray[i];
			if(set.containsKey(ch) && set.get(ch) > j) {
				if(i - 1 - j > result)
					result = i - 1 - j;				
				j = set.replace(ch, i);
			}
			else 
				set.put(ch, i);
		}
		if(i - j - 1 > result)
			result = i - j - 1;
		
		return result;
    }
	
	/**
	 * ����һ��Ļ����ϣ�ʹ��charAt�������������е��벻ͨ��ΪɶҪʹ��char�����ˣ����ϰ���
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring3(String s) {
		HashMap<Character, Integer> set = new HashMap<>();
		int result = 0;
		int i = 0,j = -1;
		int slength = s.length();
		
		for(;i < slength; ++i) {
			char ch = s.charAt(i);
			if(set.containsKey(ch) && set.get(ch) > j) {
				if(i - 1 - j > result)
					result = i - 1 - j;				
				j = set.replace(ch, i);
			}
			else 
				set.put(ch, i);
		}
		if(i - j - 1 > result)
			result = i - j - 1;
		
		return result;
    }

}
