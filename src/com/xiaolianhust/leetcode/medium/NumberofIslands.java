package com.xiaolianhust.leetcode.medium;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ����˼·��
	 * 1. ���ÿ��λ��[i,j],��һ��boolean[][]����¼�Ƿ��Ѿ����ʹ���
	 * 2. ˫��forѭ��������ÿ���ڵ㣬if(grid[i][j] == '1' && boolean[i][j] =false),ִ�в���3������ִ��2
	 * 3. �ӵ�ǰ�ڵ�������������ע��߽硣
	 * 
	 * test1:6ms, beats 32.09%��=��=��=��(�b��b;)��
	 * �ðɣ�������ǰ�Ŵ��е���˼����Ȼ����ֱ���޸ģ���������飬Ϊ�˳ɼ����ǲ����ֶ��ˡ�
	 * 
	 * test2:4ms, beats 93.74%��=��=��=��(�b��b;)��
	 * ��Ȼ����Ϊboolean��ά���鴴���Ŀ����������ٶ�Ҫ�ͺܶࡣ
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
