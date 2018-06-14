package com.xiaolianhust.leetcode.medium;

/**
 * 
 * @author 25040
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = {
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(isValidSudoku(test));
	}
	
	/**
	 * ˼·��
	 * �򵥴ֱ�����������Ԫ�ء�
	 * ʹ�þŸ������飬�����Ź��������Լ�һ������������¼��
	 * 
	 * test1:32ms ,beats 90%
	 * 
	 * �������ַ���̫�˷ѿռ��ˡ�
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
        //��ʼ��9���е�����,javaĬ��ִ���˳�ʼ�������ڴ�����ȫΪ0��
		int[][] column = new int[9][9];
		char curr;
		int currIndex;
		
		//��������Ԫ��
		for(int i = 0;i < 9;i = i + 3) {
			int[][] nine = new int[3][9];//��ʼ��3���Ź���ļ�¼����
			for(int j = 0;j < 3;++j) {
				int currRowIndex = i + j;
				int[] row = new int[9];//��ʼ��3���Ź���ļ�¼�����ʼ����ǰ�м�¼����
				for(int k = 0;k < 9;++k) {
					//System.out.println("row:" + currRowIndex + " column:" + k );
					curr = board[currRowIndex][k];
					//�ж��Ƿ�������
					if(curr == '.')
						continue;
					currIndex = curr - '1';
					//�жϵ�ǰ���Ƿ��ظ�
					if(row[currIndex] == 1) {
						//System.out.println("row:" + currRowIndex + " column:" + k + "row rep");
						return false;
					}
						
					else 
						row[currIndex] = 1;
					
					//�жϵ�ǰ�Ź����Ƿ��ظ�
					if(nine[k / 3][currIndex] == 1){
						//System.out.println("row:" + currRowIndex + " column:" + k + "nine rep");
						return false;
					}
					else
						nine[k / 3][currIndex] = 1;
					
					//�жϵ�ǰ���Ƿ��ظ�
					if(column[k][currIndex] == 1){
						//System.out.println("row:" + currRowIndex + " column:" + k + "column rep");
						return false;
					}
					else
						column[k][currIndex] = 1;
				}
			}
		}
		
		return true;
    }
	
	/**
	 * �Բۣ�����𰸾���̫�������ˣ�ͷƤ���顣
	 * ������ʹ��int[][] ���洢����ʹ��int[]������������ÿ�����ֿ���һ��λ����ʾ��
	 * ʹ�������ϵ�int��ÿ��bitλ���洢��
	 * �������ռ������ͽ�ʡ�����ˣ�̫6�ˡ�
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
	    int [] vset = new int [9];
	    int [] hset = new int [9];
	    int [] bckt = new int [9];
	    int idx = 0;
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] != '.') {
	                idx = 1 << (board[i][j] - '0') ;
	                if ((hset[i] & idx) > 0 ||
	                    (vset[j] & idx) > 0 ||
	                    (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
	                hset[i] |= idx;
	                vset[j] |= idx;
	                bckt[(i / 3) * 3 + j / 3] |= idx;
	            }
	        }
	    }
	    return true;
	}

}
