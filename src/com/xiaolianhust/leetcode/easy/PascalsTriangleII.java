package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow3(3));
	}
	
	/**
	 * ��һ��˼·��
	 * ����������ǵĻ���������·�������ɣ������Ҫn^2
	 * 
	 * test1:6ms, beats 2.24 ��=��=��=��(�b��b;)��
	 * 
	 * ����discuss��˼·��ǰ��ò�ƶ���ʹ����������ɲ�����ת����List���ص�
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int k = Math.min(rowIndex, 1);
        for(int i = 0;i <= k;++i) {
        	result.add(1);
        }
        if(rowIndex < 2)
        	return result;
        
        for(int i = 2;i <= rowIndex; ++i) {
        	result.set(0, 1);
        	int lastp;
        	int lastPrep = 1;
        	for(int j = 1;j < i;++j) {
        		lastp = result.get(j);
        		result.set(j, lastp + lastPrep);
        		lastPrep = lastp;
        	}
        	result.add(1);
        }
        return result;
    }
	
	/**
	 * �����е㣬��������ĥ����ˡ�
	 * Arrays.as(Integer[])�Ϳ��ԣ���֮ǰһֱ����Arrays.asList(int[])�ѹ�һֱ����
	 * 
	 * test1:1ms, beats, beats 99.88%��=��=��=��(�b��b;)��
	 * 
	 * ��ȥ����ôһ��ĸı�����ô�󣬿��¡������Ժ��������龡�������鰡��
	 * ���飬ţ�ƣ�
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow3(int rowIndex) {
		int[] result = new int[rowIndex + 1];
		result[0] = 1;
		for(int i = 1;i < rowIndex + 1; ++i) {
			for(int j = i;j >= 1;--j)
				result[j] += result[j - 1];
		}
		List<Integer> resultList = new ArrayList<>();
		for(int i = 0;i < rowIndex + 1;++i)
			resultList.add(result[i]);
		return resultList;
	}

}
