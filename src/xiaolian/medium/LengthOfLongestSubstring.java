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
	 * idea:使用hashset，依次读取每个字符，判断该字符是否存在于hashset中，由此来判断重复。
	 * 1. 如果重复了，记录此时的长度,记录此时hashset的数值就是对应的长度。然后索引从当前i，向前移动（i--）遍历删除hashset中的重复字符，直到前面重复的字符为止。
	 * 2. 如果该字符没有重复，那么就将他加入到set中，
	 * 
	 * 时间复杂度：2n,每个字符最多被访问了两遍，而且调用过程的框架函数调用比较多。
	 * 空间复杂度：m线性，那个数组也可以去掉使用charAt方法来调用
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
				for(int j = set.replace(ch, i) - 1;j >= 0 && set.remove(charArray[j], j);j--);//从前面重复字符开始删除之前。
			}
			else 
				set.put(ch, i);
		}
		if(set.size() > result)
			result = set.size();
		
		return result;
    }
	
	/**
	 * 该种方法借鉴参考了答案之后，写出来的。我上面也使用了map，就没想到这一点。要学习的地方还有很多啊。
	 * 时间界限：线性。真正只遍历了一遍。
	 * 空间界限：线性，因为map的存在
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
	 * 在上一版的基本上，使用charAt方法。现在我有点想不通我为啥要使用char数组了，智障啊。
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
