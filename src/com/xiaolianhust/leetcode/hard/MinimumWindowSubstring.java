package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
	private static char ch;

	public static void main(String[] args) {
		System.out.println(minWindow3("ADOBECODEBANC","ABC"));
	}
	
	/**
	 * 第一种思路：
	 * 线性思路：
	 * 依次遍历过去，必须寻找一种有效的方法能够存储对应，t中每个字母的出现在s的坐标。
	 * 首先获取，t.length。必须先找到t字符串中每个不同字符的存储位置，由此可以设立一个标记来达成。从头开始，
	 * 每找到一个互异的字符，计数器+1，当计数器达到length后，开始第二模式，
	 * 第二模式下，默认已经起码找到了第一个符合要求的windows,此时后续的遍历中又找到了了重复的该字母，
	 * 则如果前面已找到字符具有最小的索引数值，那么则更新它，否则。（错误，不能这样。）
	 * 
	 * 设n = t.length, 然后建立一个n数组来缓存索引位置，每个检查到这些字符都会更新该数组，然后计算此时的width，然后
	 * 跟之前的比较，如果更小的化，那么记录下此时的边界。
	 * 思路出现重大漏洞：我日了，我没考虑到t中可能会出现重复元素的情况。
	 * 
	 * 核心问题在于：如何让map提供重复字符的映射服务。
	 * 第一个想法：让map，的value成为一个List<Integer>,这样list中存储分别时同样字符的第i个字符。
	 * 针对有重复的字符，我们还需要建立一个index映射，告诉第一个map，到底是list中的第几个数字
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow2(String s, String t) {
		int left = -1, right = -1;
        int tn = t.length();
        int sn = s.length();
        int width = 0;
        int[] indexes = new int[tn];
        HashMap<Character, List<Integer>> map = new HashMap<>();
        HashMap<Character, Integer> repeatIndexMap = new HashMap<>();
        for(int i = 0;i < tn;++i) {
        	List<Integer> lst = map.get(t.charAt(i));
        	if(lst == null)
        		lst = new ArrayList<>(Arrays.asList(i));
        	else{
        		repeatIndexMap.put(t.charAt(i), 0);
        		lst.add(i);       
        	}
        	map.put(t.charAt(i), lst);
        }
        Arrays.fill(indexes, -1);
        
        //首先得找到第一个符合条件的windows
        int cnt = 0;
        int i = 0;
        for(;i < sn;++i) {
        	char ch = s.charAt(i);
        	List<Integer> maplst = map.get(ch);
        	if(maplst != null) {
        		int mapi = getArrIndex(maplst, repeatIndexMap, ch);
        		int old = indexes[mapi];
        		indexes[mapi] = i;
        		if(old == -1) {
	        		++cnt;
	        		if(cnt == tn) {
	        			right = i;
	        			break;
	        		}
        		}
        	}
        }
        //如果cnt < tn，说明没找到这个windows
        if(cnt != tn)
        	return "";
        left = findMinIndex(indexes, tn, tn);
        width = right - left;
        //找到第一个符合条件的window后，在后续的字符里面寻找更短的。
        for(i++;i < sn;++i) {
        	char ch = s.charAt(i);
        	List<Integer> maplst = map.get(ch);
        	if(maplst != null) {
        		int mapi = getArrIndex(maplst, repeatIndexMap, ch);
        		indexes[mapi] = i;
        		int minIndex = findMinIndex(indexes, tn, mapi);
        		if(i - minIndex < width) {
        			width = i - minIndex;
        			left = minIndex;
        			right = i;
        		}
        	}
        }
        
        return s.substring(left, right + 1);
	}
	
	
	
	private static int getArrIndex(List<Integer> maplst, HashMap<Character, Integer> repeatIndexMap, char ch) {
		int mapi;
		if(maplst.size() == 1) {//针对不重复的字符
			mapi = maplst.get(0);
		}
		else {
			int repeatIndex = repeatIndexMap.get(ch) % maplst.size();
			mapi = maplst.get(repeatIndex);
			repeatIndexMap.put(ch, repeatIndex + 1);
		}
		return mapi;
	}

	public static String minWindow(String s, String t) {
        int left = -1, right = -1;
        int tn = t.length();
        int sn = s.length();
        int width = 0;
        int[] indexes = new int[tn];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0, j = 0;i < tn;++i) {
        	map.put(t.charAt(i) + "", j++);
        }
        Arrays.fill(indexes, -1);
        
        //首先得找到第一个符合条件的windows
        int cnt = 0;
        int i = 0;
        for(;i < sn;++i) {
        	ch = s.charAt(i);
        	@SuppressWarnings("unlikely-arg-type")
			Integer mapi = map.get(ch);
        	if(mapi != null) {
        		int old = indexes[mapi];
        		indexes[mapi] = i;
        		if(old == -1) {
	        		++cnt;
	        		if(cnt == 1)
	        			left = i;
	        		if(cnt == tn) {
	        			right = i;
	        			width = right - left;
	        			break;
	        		}
        		}
        	}
        }
        //如果cnt < tn，说明没找到这个windows
        if(cnt != tn)
        	return "";
        
        for(i++;i < sn;++i) {
        	char ch = s.charAt(i);
        	@SuppressWarnings("unlikely-arg-type")
			Integer mapi = map.get(ch);
        	if(mapi != null) {
        		indexes[mapi] = i;
        		int minIndex = findMinIndex(indexes, tn, mapi);
        		if(i - minIndex < width) {
        			width = i - minIndex;
        			left = minIndex;
        			right = i;
        		}
        	}
        }
        
        return s.substring(left, right + 1);
    }
    
    /**
     * 
     * @param indexes
     * @param tn
     * @param mapi
     * @return
     */
	private static int findMinIndex(int[] indexes, int tn, Integer mapi) {
		int result = Integer.MAX_VALUE;
		for(int i = 0;i < mapi; ++i) {
			result = Math.min(indexes[i], result);
		}
		
		for(int i = mapi + 1;i < tn;++i) {
			result = Math.min(indexes[i], result);
		}
		
		return result;
	}
	
public static String minWindow3(String s, String t) {
        
        int s_len = s.length();
        int t_len = t.length();
        int ruler = t_len;
        
        int res = Integer.MAX_VALUE;
        int start = 0;
        
        int[] freq = new int[128];
        
        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();
        
        // count char in t
        for (char c : c_t)
            freq[c]++;
        
        int i = 0, j = 0;
        while (j < s_len) {
            
            // whether ruler can expand
            if (freq[c_s[j++]]-- >= 1)
                ruler--;
            
            // if ruler == 0, it means all char in t has been contained in window now
            while (ruler == 0) {
                
                // choose min window
                if (res > j - i) {
                    res = j - i;
                    start = i;
                }
                
                // narrow left border
                if (freq[c_s[i++]]++ == 0)
                    ruler++;
                    
            }
            
        }
        
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
        
    }
}
