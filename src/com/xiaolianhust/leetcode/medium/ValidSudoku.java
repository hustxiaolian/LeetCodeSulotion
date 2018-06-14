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
	 * 思路：
	 * 简单粗暴，遍历所有元素。
	 * 使用九个列数组，三个九宫格数组以及一个列数组来记录。
	 * 
	 * test1:32ms ,beats 90%
	 * 
	 * 但是这种方法太浪费空间了。
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
        //初始化9个列的数组,java默认执行了初始化，即内存区域全为0；
		int[][] column = new int[9][9];
		char curr;
		int currIndex;
		
		//遍历所有元素
		for(int i = 0;i < 9;i = i + 3) {
			int[][] nine = new int[3][9];//初始化3个九宫格的记录数组
			for(int j = 0;j < 3;++j) {
				int currRowIndex = i + j;
				int[] row = new int[9];//初始化3个九宫格的记录数组初始化当前行记录数字
				for(int k = 0;k < 9;++k) {
					//System.out.println("row:" + currRowIndex + " column:" + k );
					curr = board[currRowIndex][k];
					//判断是否是数字
					if(curr == '.')
						continue;
					currIndex = curr - '1';
					//判断当前行是否重复
					if(row[currIndex] == 1) {
						//System.out.println("row:" + currRowIndex + " column:" + k + "row rep");
						return false;
					}
						
					else 
						row[currIndex] = 1;
					
					//判断当前九宫格是否重复
					if(nine[k / 3][currIndex] == 1){
						//System.out.println("row:" + currRowIndex + " column:" + k + "nine rep");
						return false;
					}
					else
						nine[k / 3][currIndex] = 1;
					
					//判断当前列是否重复
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
	 * 卧槽，这个答案就是太尼玛秀了，头皮发麻。
	 * 我想是使用int[][] 来存储，他使用int[]来，但是他将每个数字看成一个位级表示。
	 * 使用数字上的int的每个bit位来存储。
	 * 这样，空间立即就节省下来了，太6了。
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
