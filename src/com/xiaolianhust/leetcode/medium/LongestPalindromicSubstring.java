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
	 * 思路：
	 * 1.首先我们分析下回文子字符串的性质
	 * 	a.期间的每个字符可能有一个(aba)，两个(bb)或者多个(bbbbbbbb)
	 * 	b.任意一个长度大于1的字符串，其回文字符串至少有一个字符的数目大于等于2
	 * 
	 * 步骤：
	 * 1. 遍历字符串的每个字符，并且建立hashSet，用于存储已经扫描过的字符集合。
	 * 2. 遍历过程中，只要发现当前字符与已扫描字符集合重复，我们就进行回文的判断。并且暂存子字符串。
	 * 3. 重复步骤2，直到有扫描到一个字符，它不能和前面的字串形成一个更大的回文字符串。我们把结果保存，然后清空hashSet继续扫描
	 * 			字符。
	 * 
	 * 一个比较大的问题，就是我暂存一个结果后，我从哪里重新开始这个过程。
	 * 1.一个实验性质的想法：我从步骤2第一次检索到重复字符的时候开始，因为如果前面字符子集合完全不重复，当前不可能是回文。
	 * 	之所以会有这个问题是因为：小回文子字符串可能与一个后续更大的回文子字符串重叠。
	 * 
	 * 行了，思路大概60%成熟了，开始编码，在编码中探索需要注意的细节问题。
	 * 
	 * bug 1 k 越界访问了
	 * bug 2 少考虑了一种情况如果bab，这种重复的时候
	 * bug 3 p_start < 0发生了越界访问错误。
	 * bug 4 忘记if(s.charAt(p_start--) == s.charAt(p_end++)这条语句无论条件是否成立都会发生下标的移动
	 * bug 5 忘记了java的函数调用和参数返回时值传递。 
	 * bug 6 对于字符串ccc，输出错误。原因在于，这种算法时优先检索xxbbxx这种形式的而不是xbabx这种形式。
	 * 			讲道理，后者相比于前者有更长的潜力，或者说我们两个都要测试一遍检索一遍
	 * bug 7 string类的subString（begin，end）没法完全截取最后一个字符。
	 * bug 8 面对aaaaaa的时候的，该算法总是会删除掉前面一点，
	 * bug 9 还有第三种形式我竟然没注意到与aba先对的还有bab，这两种在程序看来还真是不一样。
	 * 
	 * 改进1：否认bug 7 是我对subString没看说明，凭空臆测了。
	 * 
	 * 时间复杂度：最坏的情形。完全只有一个字符aaaaaaaaaaaaaaaa,这样还是得二次得时间复杂度，
	 * 				或者说ababababab这样高度重复，能形成很多回文字串的那么我的算法会对每个可能符文都判断，相比于暴力三次方的方法
	 * 				节省下来的时间比较少。
	 * 空间复杂度：线性
	 * 
	 * test1: 118ms, beats(26.03%)(笑，雾，ε=ε=ε=┏(゜ロ゜;)┛)
	 * @param s
	 * @return
	 */
	public static String longestPalindromicSubstring1(String s) {
		//初始化各变量
		//String subStr = s.substring(0, 1);
		String result = s.substring(0, 1);
		//这里只能曲线救国下，我不知道为什么没有char的包装类。这里使用string的codePointAt方法来检索重复。
		HashMap<Integer,Integer> set = new HashMap<>(); 
		int len = s.length();
		int p_start = 0;
		int p_end = 0;
		int i = 0;
		 
		//遍历每个字符串每个字符
		while(i < len) {
			int currentCharCodePoint = s.codePointAt(i);
			//首先判断当前字符是否出现了重复
			if(set.containsKey(currentCharCodePoint)) {
				//好出现重复了，又可以分为两种情况。
				//1.下一个字符的加入可以形成更长的回文
				//2.下一个字符的加入不可以形成回文
				
				//判断重复的字符是否是紧邻的，即xabax的形式
				if(p_start - 1 >= 0 && s.charAt(p_start - 1) == s.charAt(p_end)) {
					//bab这样的情况也是需要的
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start - 1, p_end);
				}
				if(p_end + 1 < s.length() && s.charAt(p_start) == s.charAt(p_end + 1)) {
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start, p_end + 1);
				}
				//判断回文形式是否为xxxbbxxx这种形式
				if(s.charAt(p_start) == s.charAt(p_end)) {
					result = pailindromicCheckAndSaveLongerSubstring(s, result, p_start, p_end);
				}
				//判断回文形式为bab
				
				
				//如果不是，就说明，无法形成回文，这样，我们需要抛弃掉前面集合中 当前重复字母之前的那些字符
				//当然，就算是已经完成了检索并且提取了一条回文，我们同样需要抛弃一部分
				//因为，它们没法形成回文
				//首先获取那个重复的字符的索引
				int k = set.get(currentCharCodePoint);
				//然后向前一路删除
				while(k >= 0 && set.containsKey(s.codePointAt(k))) {
					set.remove(s.codePointAt(k));
					--k;
				}
				
			}
			//如果没包含说明前面的字符集合一点都没有重复,添加到集合中，继续下一个,并且用两个p指示好。
			set.put(currentCharCodePoint,i);
			p_start = i++;
			p_end = i;
		}
		
		return result;
	}
	
	/**
	 * 用来确定当前回文的最大延伸界限在哪里，即当前状态的最长回文。
	 * 如果这个回文比result暂存的更长，则替换，否则按照原来的返回
	 * 时间复杂度是线性。空间复杂度也是线性。
	 * @param s
	 * @param result
	 * @param p_start
	 * @param p_end
	 * @return
	 */
	public static String pailindromicCheckAndSaveLongerSubstring(String s, String result, int p_start, int p_end) {
		String subStr;

		//如果是，说明起码可以形成一个两个长度的回文。xxbbxxx
		//该循环相当于一个回文检查程序，去检查这个回文的索引边界
		while(p_start >= 0 && p_end < s.length() && s.charAt(p_start) == s.charAt(p_end)) {
			p_start--;
			p_end++;
		}
		//bug 7 string类的subString（begin，end）没法完全截取最后一个字符。所以只能这样了。
		
		subStr = s.substring(p_start + 1, p_end);
	
		//如果这个回文字符串的长度更长，那么替换结果
		if(subStr.length() > result.length()) {
			System.out.println("索引位置"+ p_start + "," + p_end);
			//System.out.println(subStr);
			result = subStr;
		}
		//之后，从这个第一个重复的地方继续开始，循环。
		return result;
	}
	
	/**
	 * 这次是review整理下过往做完的20道题，并且对它们进行分类，以便于以后复习，整理，提高。
	 * 这次的思路就是solution那个掉渣天的思路。
	 * 具体为：
	 * 1. 指定一个字母引用，来遍历整个字符串的每个字母。
	 * 2. 针对每次指定的字母，我们以它为中心向两边扩展。
	 * 		(注意会出现两种情况，一种以该字母的中心对称，一种是包含该字母的镜像对称)
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
