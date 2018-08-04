package com.xiaolianhust.leetcode.medium;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 核心思路：
	 * 1. 针对每个位置[i,j],用一个boolean[][]来记录是否已经访问过。
	 * 2. 双重for循环，访问每个节点，if(grid[i][j] == '1' && boolean[i][j] =false),执行步骤3，否则执行2
	 * 3. 从当前节点广度优先搜索。注意边界。
	 * 
	 * test1:6ms, beats 32.09%ε=ε=ε=┏(゜ロ゜;)┛
	 * 好吧，看了下前排大佬的意思，竟然可以直接修改，传入的数组，为了成绩真是不择手段了。
	 * 
	 * test2:4ms, beats 93.74%ε=ε=ε=┏(゜ロ゜;)┛
	 * 果然是因为boolean二维数组创建的开销，导致速度要低很多。
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
        int result = 0;
        int rn = grid.length;
        if(rn == 0) return result;
        int cn = grid[0].length;
        boolean[][] used = new boolean[rn][cn];
        for(int i = 0;i < rn;++i) {
        	for(int j = 0;j < cn;++j) {
        		if(BFS(grid, used, i, j, rn, cn))
        			++result;
        	}
        }
        return result;
    }

	private final boolean BFS(char[][] grid, boolean[][] used, int i, int j, int rn, int cn) {
		if(grid[i][j] == '1' && !used[i][j]) {
			used[i][j] = true;
			if(i - 1 >= 0) BFS(grid, used, i - 1, j, rn, cn);
			if(i + 1 < rn) BFS(grid, used, i + 1, j, rn, cn);
			if(j - 1 >= 0) BFS(grid, used, i, j - 1, rn, cn);
			if(j + 1 < cn) BFS(grid, used, i, j + 1, rn, cn);
			return true;
		}
		return false;
	}
	
	public int numIslands2(char[][] grid) {
        int result = 0;
        int rn = grid.length;
        if(rn == 0) return result;
        int cn = grid[0].length;
        for(int i = 0;i < rn;++i) {
        	for(int j = 0;j < cn;++j) {
        		if(BFS(grid, i, j, rn, cn))
        			++result;
        	}
        }
        return result;
    }

	private final boolean BFS(char[][] grid, int i, int j, int rn, int cn) {
		if(grid[i][j] == '1') {
			grid[i][j] = '0';
			if(i - 1 >= 0) BFS(grid, i - 1, j, rn, cn);
			if(i + 1 < rn) BFS(grid, i + 1, j, rn, cn);
			if(j - 1 >= 0) BFS(grid, i, j - 1, rn, cn);
			if(j + 1 < cn) BFS(grid, i, j + 1, rn, cn);
			return true;
		}
		return false;
	}
}
