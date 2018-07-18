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
	 * ˼·��
	 * ������ѭ�����ơ�
	 * Ŀǰ�������Լ��������
	 * 1. ÿ��ֻ�ܳ�һ�������˶�һ��
	 * 2. �ù��˵ĸ��Ӳ����ظ����á�
	 * 3. ע��߽��ϡ�
	 * 
	 * ʹ��used[][]�������ж��Ƿ��Ѿ��ù��ˡ�ÿ��ѭ���ڲ�����used��������֤��ʼ����ʱ����false
	 * test1:188ms, beats 6.86%��=��=��=��(�b��b;)��
	 * 
	 * ��ʵû��Ҫ��ֱ�Ӵ���һ�μ����ˣ���Ϊÿ�β��ɹ����ὲԭ����·����Ϊfalse.
	 * test2:9ms, beats 96.70%��=��=��=��(�b��b;)��(*^_^*)���ǡ�����ÿ�δ���used�����е�󰡣�û�뵽��ô����
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist(char[][] board, String word) {
		int rn = board.length;//����
		int cn = board[0].length;//����
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
		//��׼����
		if(k >= word.length())
			return true;
		else if(i < 0 || i >= rn || j < 0 || j >= cn || used[i][j])
			return false;
		//һ������
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
