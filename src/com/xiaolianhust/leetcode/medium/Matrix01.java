package com.xiaolianhust.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	/**
	 * �þö�û������BFS����Ŀ�ˣ������ĺܣ��ú���ϰ��������ȥ�һ����֪ʶ�ͼ��ɡ�
	 * 
	 * ˼·��BFS�������������
	 * 20min��δ�����ú�ѧϰ�ܽ��¡��������Ҳ����٣���Ϊ��ʱ��������Ͳ�����̡�
	 * 
	 * ����⣬�һ����ٻ���review�µġ��ǳ��ú;����һ���⡣
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		//1.��������Ϊ0�Ĳ��֣���ʼ��Ϊ0��������Ϊ���ӷ���queue�С�Ϊ1�Ĳ��ֳ�ʼ��Ϊ�����
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0;i < m;++i) {
			for(int j = 0;j < n;++j) {
				if(matrix[i][j] == 0)
					queue.offer(new int[] {i,j});
				else
					matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		//�ĸ����򣬱����������ڲ�����
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		//BFS��ÿ���ڵ���ĸ�������й������������
		//ʵ���ϣ�ֻ����Щ������һ��0�ڵ���ܹ�ͨ��if�жϡ�
		//���ȥ�����һ��<=�Ĳ�����������ôÿ���ڵ㶼���������ͼ�����ҵõ�����Ľ����
		//��һ���龰����ͼ�����������еĺ�����������½������
		while(!queue.isEmpty()) {
			int[] cell = queue.poll();
			for(int[] d : dirs) {//�����൱���ڽӱ������
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				//���if���������ĺ������㡣
				if(r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cell[0]][cell[1]] + 1)
					continue;
				queue.add(new int[] {r, c});
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
			}
		}
		return matrix;
    }
}
