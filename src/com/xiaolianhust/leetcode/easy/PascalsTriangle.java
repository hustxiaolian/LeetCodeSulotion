package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	/**
	 * ��һ��˼·��
	 * ������������������ɵĹ���������
	 * 
	 * test1:1ms, beats 99.87%��=��=��=��(�b��b;)��
	 * @param numRows
	 * @return
	 */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0;i < numRows;++i) {
        	List<Integer> newRow = new ArrayList<>();
        	result.add(newRow);
        	newRow.add(1);
        	if(i == 0) continue;
        	for(int j = 1;j < i;++j) {
        		List<Integer> lastRow = result.get(i - 1);
        		newRow.add(lastRow.get(j - 1) + lastRow.get(j));
        	}
        	newRow.add(1);
        }
        
        return result;
    }
}
