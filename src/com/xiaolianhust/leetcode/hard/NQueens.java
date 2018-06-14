package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(1));
	}
	
	/**
	 * 第一种思路：
	 * 还是前面熟悉的for+递归的思路.
	 * 
	 * test1:4ms, beats 99.84%ε=ε=ε=┏(゜ロ゜;)┛
	 * 比别人更快的原因就在于我是在已经出现了结果再生成结果的，
	 * 而且使用了char数组，减少了反复生成不需要字符串的系统开销。
	 * 都是一些细节上的优化吧。
	 * 
	 * 总之，这次的编码基本上我很满意的。
	 * 
	 * @param n
	 * @return
	 */
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] columns = new int[n];
        search(0, n, result, columns);
        return result;
    }
	
	/**
	 * 具体的思路：
	 * 基准情况，curr = n，递归到了尽头，代表有了结果，oneAns加入结果中，否则它中途就返回了，没有结果
	 * @param curr
	 * @param n
	 * @param result
	 * @param forbid
	 * @param oneAns
	 */
	private static void search(int curr, int n, List<List<String>> result, int[] columns) {
		if(curr == n) {
			List<String> oneAns = new ArrayList<>();
			char[] buf = new char[n];
			Arrays.fill(buf, '.');
			for(int i = 0;i < n;++i) {
				buf[columns[i]] = 'Q';
				oneAns.add(String.valueOf(buf));
				buf[columns[i]] = '.';
			}
			result.add(oneAns);
			return;
		}
		//根据前面已经存在的皇后，计算当前递归行中，不能放置皇后的位置。
		int[] forbid = new int[n];
		for(int i = 0;i < curr;++i) {
			int temp = columns[i];
			//行的错开，由递归层数控制。列的错开。
			forbid[temp] = 1;
			//斜向的错开
			if(temp + (curr - i) < n)
				forbid[temp + (curr - i)] = 1;
			if(temp - (curr - i) >= 0)
				forbid[temp - (curr - i)] = 1;
		}
		//根据forbid数组的结果，递归进入下一层次
		for(int i = 0;i < n;++i) {
			if(forbid[i] == 0) {
				columns[curr] = i;
				search(curr + 1, n, result, columns);
			}
		}
	}

}
