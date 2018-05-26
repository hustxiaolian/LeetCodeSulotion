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

提示：根据题意，两个处于相同组的单词长度必须是一样长度。
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		groupAnagrams2(new String[] {"eat","tea","tan","ate","nat","bat"});
	}
	
	/**
	 * 第一种思路：我有个大胆的想法，但是这个有隐患的。就是把所有的字符计算一个整数来表示。
	 * 不行，这个想法过于大胆和激进了，使用一个长度为26的数组来表示。
	 * 比较两个字符集合是否属于同一个组，就是判断他们对应的数组是否相等。
	 * 具体思路步骤：
	 * 1. 初始化变量。初始化返回值。
	 * 2. 遍历每个字符串，生成当前字符串对应的数组对象，然后使用hash来判断是否在以前的数组对象是否相等。
	 * 3. 有同样的数组就直接在答案中插入答案里面，如果不是就创建新的节点。
	 * 
	 * 看了答案，我想到了使用计数的方式来判断，我犯难之处在与如何结合数组来hashmap，而它直接将其转换为数组元素拼接成一个
	 * 字符串用作HashMap的索引，妙。
	 * 
	 * 那么思路就很清晰了：
	 * 1. 初始化答案，判断特殊情况。
	 * 2. 遍历每个字符串，针对每个字符串，生成对应的计数数组，然后把技术数组元素转换为字符串。
	 * 3. 使用上面的字符串作为HashMap的索引，判断以前map中是否含有，如果有则把当前字符串加入到map对应索引下的list中
	 * 4. 完成遍历后，把每个list加入到result中。
	 * 
	 * test1:46ms, beats 15.18%
	 * 
	 * 后来又看了前排大佬的想法。确实使用StringBuffer这种方式太浪费时间了。改成对char数组的排序.
	 * 其实讲道理，第一种方法只对字符串的每个字符遍历了一遍，线性。但是没办法标准库的sort函数太强大了。
	 * 改成我自己的思路，弃用Stringbuffer后，改成String.valueof函数后，效率增幅巨大。
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
