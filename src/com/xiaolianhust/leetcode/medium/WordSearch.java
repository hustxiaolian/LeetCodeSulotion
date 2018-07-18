package com.xiaolianhust.leetcode.medium;

public class WordSearch {
	
	public static void main(String[] args) {
		System.out.println(exist(new char[][] {
			{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}
		}, "ABCESEEEFS"));
	}
	/**
	 * 思路：
	 * 基本的循环控制。
	 * 目前想出来的约束条件：
	 * 1. 每次只能朝一个方法运动一格。
	 * 2. 用过了的格子不能重复利用。
	 * 3. 注意边界上。
	 * 
	 * 使用used[][]数组来判断是否已经用过了。每次循环内部创建used数组来保证初始化的时候都是false
	 * test1:188ms, beats 6.86%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 其实没必要，直接创建一次即可了，因为每次不成功都会讲原来的路径置为false.
	 * test2:9ms, beats 96.70%ε=ε=ε=┏(゜ロ゜;)┛(*^_^*)真是。。这每次创建used开销有点大啊，没想到这么夸张
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist(char[][] board, String word) {
		int rn = board.length;//行数
		int cn = board[0].length;//列数
		int wn = word.length();
		if(wn > rn * cn) return false;
		for(int i = 0;i < rn;++i) {
			for(int j = 0;j < cn;++j) {
				boolean[][] used = new boolean[rn][cn];
				if(helper(i, j, used, 0, board, rn, cn, word))
					return true;
			}
		}
        return false;
    }
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param used
	 * @param k 
	 * @param board
	 * @param cn 
	 * @param rn 
	 * @param word 
	 * @return
	 */
	private static boolean helper(int i, int j, boolean[][] used, int k, char[][] board, int rn, int cn, String word) {
		//基准情形
		if(k >= word.length())
			return true;
		else if(i < 0 || i >= rn || j < 0 || j >= cn || used[i][j])
			return false;
		//一般情形
		if(board[i][j] == word.charAt(k)) {
			used[i][j] = true;
			boolean result = helper(i + 1, j, used, k + 1, board, rn, cn, word) ||
					helper(i - 1, j, used, k + 1, board, rn, cn, word) ||
					helper(i, j + 1, used, k + 1, board, rn, cn, word) ||
					helper(i, j - 1, used, k + 1, board, rn, cn, word);
			if(result)
				return true;
			else
				used[i][j] = false;
		}
		else
			return false;
		return false;
	}
}
