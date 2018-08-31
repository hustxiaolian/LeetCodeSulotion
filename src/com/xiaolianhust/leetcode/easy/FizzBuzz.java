package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(15));
	}
	
	/**
	 * ˼·��
	 * �������������ˣ��Ȱ�3��λ�û���Fizz��Ȼ�󽫰�5�ı�������Buzz����������������FizzBuzz��
	 * Ȼ���ٰ����ַ���ȥ��
	 * 
	 * test1: 2ms, beats 99.85% ��=��=��=��(�b��b;)��
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        for(int i = 3;i <= n;i += 3) {
        	result[i - 1] = "Fizz";
        }
        for(int i = 5;i <= n;i += 5) {
        	if(result[i - 1] == null)
        		result[i - 1] = "Buzz";
        	else
        		result[i - 1] += "Buzz";
        }
        
        for(int i = 1;i <= n;++i) {
        	if(result[i - 1] == null)
        		result[i - 1] = String.valueOf(i);
        }
        return Arrays.asList(result);
    }
}
