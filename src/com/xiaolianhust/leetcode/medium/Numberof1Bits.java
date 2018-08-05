package com.xiaolianhust.leetcode.medium;

public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(-1));
	}
	
	/**
	 * ˼·��
	 * �����ң���˼������32��bit��һ���򵥵ļ�������
	 * 
	 * test1:1ms, beats 99.44%��=��=��=��(�b��b;)��
	 * 
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0;i < 32;++i) {
        	int curr = mask & n;
        	if(curr != 0)
        		++result;
        	/*
        	else if(curr > n)���ﲻ�ܼӣ�������ĳЩ�ط�����������С�
        		break;
        		*/
        	mask <<= 1;
        }
        return result;
    }

}
