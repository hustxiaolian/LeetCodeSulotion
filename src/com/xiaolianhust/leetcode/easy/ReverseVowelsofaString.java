package com.xiaolianhust.leetcode.easy;

public class ReverseVowelsofaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("hello"));
	}
	
	/**
	 * 思路：
	 * 还是之前的思路，双指针来完成。这次不同的就是在遍历的过程中加上元音字母的判断。
	 * 
	 * test:2ms, beats 100.0% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param s
	 * @return
	 */
	static final boolean[] arr2 = new boolean[128];
	{
		arr2['a'] = true;
		arr2['e'] = true;
		arr2['i'] = true;
		arr2['o'] = true;
		arr2['u'] = true;
		arr2['A'] = true;
		arr2['E'] = true;
		arr2['I'] = true;
		arr2['O'] = true;
		arr2['U'] = true;
	}
	public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int i = 0, j = n - 1;
        while(i < j) {
        	while(i < j && !arr2[arr[i]])
        		i++;
        	while(i < j && !arr2[arr[j]])
        		j--;
        	
        	if(i != j) {
        		char temp = arr[i];
        		arr[i++] = arr[j];
        		arr[j--] = temp;
        	}
        }
        return String.valueOf(arr);
    }
}
