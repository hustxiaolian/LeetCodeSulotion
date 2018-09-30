package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(selfDividingNumbers(162,168));
	}
	
	/**
	 * ˼·��
	 * ��򵥣��ֱ���˼·���Ǳ�����
	 * ���⣬ֵ�ù�ע���ǣ����Ҫ���γɵ�ǰ���ֵ�ÿ��λ���������ķֽ�����֮һ��
	 * ����128�У�1 2 8 ���������ӵ�һ�ݣ�Ҳ����˵128%��1*2*8 ��==0
	 * @param left
	 * @param right
	 * @return
	 */
	public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left;i <= right; ++i) {
        	if(i % 10 == 0) continue;
        	int j;
        	for(j = i;j > 0;j /= 10) {
        		int d = j % 10;
        		if(d == 0 || i % d != 0) break;
        	}
        	if(j == 0)
        		res.add(i);
        }
        return res;
    }
}
