package com.xiaolianhust.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	/**
	 * 好久都没有碰过BFS的题目了，手生的很，好好练习两道尝试去找回相关知识和技巧。
	 * 
	 * 思路：BFS广度优先搜索。
	 * 20min，未果，好好学习总结下。不过，我不气馁，因为当时本身的理解就不够深刻。
	 * 
	 * 这道题，我还会再回来review下的。非常好和经典的一道题。
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		//1.讲数组中为0的部分，初始化为0，并且作为种子放入queue中。为1的部分初始化为无穷大，
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0;i < m;++i) {
			for(int j = 0;j < n;++j) {
				if(matrix[i][j] == 0)
					queue.offer(new int[] {i,j});
				else
					matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		//四个方向，便于在数组内部遍历
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		//BFS对每个节点的四个方向进行广度优先搜索。
		//实际上，只有哪些四周有一的0节点才能够通过if判断。
		//如果去掉最后一个<=的测试条件，那么每个节点都会遍历整个图，并且得到错误的结果。
		//用一个情景想象图就是四周所有的海军疯狂的向内陆进发。
		while(!queue.isEmpty()) {
			int[] cell = queue.poll();
			for(int[] d : dirs) {//这里相当于邻接表遍历。
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				//这个if就是这道题的核心亮点。
				if(r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cell[0]][cell[1]] + 1)
					continue;
				queue.add(new int[] {r, c});
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
			}
		}
		return matrix;
    }
}
