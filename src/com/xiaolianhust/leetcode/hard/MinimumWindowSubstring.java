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
	 * ��һ��˼·��
	 * ����˼·��
	 * ���α�����ȥ������Ѱ��һ����Ч�ķ����ܹ��洢��Ӧ��t��ÿ����ĸ�ĳ�����s�����ꡣ
	 * ���Ȼ�ȡ��t.length���������ҵ�t�ַ�����ÿ����ͬ�ַ��Ĵ洢λ�ã��ɴ˿�������һ���������ɡ���ͷ��ʼ��
	 * ÿ�ҵ�һ��������ַ���������+1�����������ﵽlength�󣬿�ʼ�ڶ�ģʽ��
	 * �ڶ�ģʽ�£�Ĭ���Ѿ������ҵ��˵�һ������Ҫ���windows,��ʱ�����ı��������ҵ������ظ��ĸ���ĸ��
	 * �����ǰ�����ҵ��ַ�������С��������ֵ����ô������������򡣣����󣬲�����������
	 * 
	 * ��n = t.length, Ȼ����һ��n��������������λ�ã�ÿ����鵽��Щ�ַ�������¸����飬Ȼ������ʱ��width��Ȼ��
	 * ��֮ǰ�ıȽϣ������С�Ļ�����ô��¼�´�ʱ�ı߽硣
	 * ˼·�����ش�©���������ˣ���û���ǵ�t�п��ܻ�����ظ�Ԫ�ص������
	 * 
	 * �����������ڣ������map�ṩ�ظ��ַ���ӳ�����
	 * ��һ���뷨����map����value��Ϊһ��List<Integer>,����list�д洢�ֱ�ʱͬ���ַ��ĵ�i���ַ���
	 * ������ظ����ַ������ǻ���Ҫ����һ��indexӳ�䣬���ߵ�һ��map��������list�еĵڼ�������
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
        
        //���ȵ��ҵ���һ������������windows
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
        //���cnt < tn��˵��û�ҵ����windows
        if(cnt != tn)
        	return "";
        left = findMinIndex(indexes, tn, tn);
        width = right - left;
        //�ҵ���һ������������window���ں������ַ�����Ѱ�Ҹ��̵ġ�
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
		if(maplst.size() == 1) {//��Բ��ظ����ַ�
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
        
        //���ȵ��ҵ���һ������������windows
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
        //���cnt < tn��˵��û�ҵ����windows
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
