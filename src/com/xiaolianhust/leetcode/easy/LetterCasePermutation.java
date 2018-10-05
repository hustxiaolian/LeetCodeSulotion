package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCasePermutation("a1bc"));
	}

	/**
	 * 思路：
	 * 1. 使用一个容器（估计队列最合适）来存储中间变量。
	 * 2. 然后遍历整个字符串S，然后每找到一个英文字符就编程其对应的符串插入，然后把新的组合插入。
	 * @param S
	 * @return
	 */
    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        for(int i = 0;i < S.length(); ++i) {
        	char ch = S.charAt(i);
        	char oppch = 0;;
        	//判断是否是字母，并且找到对应的大写或者小写字符
        	if(ch >= 'a' && ch <= 'z') {
        		oppch = (char) (ch - ('a' - 'A'));
        	} else if(ch >= 'A' && ch <= 'Z')
        		oppch = (char) (ch + ('a' - 'A'));
        	//然后for循环，把这种可能性改变，插入到容器中所有的元素中
        	if(oppch != 0) {
        		int n = result.size();
        		for(int j = 0;j < n;++j) {
        			String currS = result.get(j);
        			result.add(currS.substring(0, i) + oppch + currS.substring(i + 1));
        		}
        	}
        	
        }
        return result;
    }
}
