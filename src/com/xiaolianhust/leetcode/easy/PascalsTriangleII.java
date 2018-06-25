package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow3(3));
	}
	
	/**
	 * 第一种思路：
	 * 按照杨辉三角的基本生成套路，来即可，因此需要n^2
	 * 
	 * test1:6ms, beats 2.24 ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 看了discuss中思路，前排貌似都是使用数组来完成操作后，转换成List返回的
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
	 * 这里有点，我终于琢磨清楚了。
	 * Arrays.as(Integer[])就可以，我之前一直都是Arrays.asList(int[])难怪一直报错
	 * 
	 * test1:1ms, beats, beats 99.88%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 我去，这么一点的改变差距这么大，可怕。看来以后能用数组尽量用数组啊。
	 * 数组，牛逼！
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
