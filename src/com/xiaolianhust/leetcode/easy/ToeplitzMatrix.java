package com.xiaolianhust.leetcode.easy;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isToeplitzMatrix(new int[][] {
			{1,2,3,4},
			{5,1,2,3},
			{9,5,3,2}
		}));
	}
	
	/**
	 * ˼·:
	 * һ���е�ɨ�裬ÿ�αȽ������д�һ��
	 * ��i-1�����ƶ�һ�����i�ж�Ӧ��λ�õ�Ԫ���Ƿ���ȡ�
	 * 
	 * test1: 22ms, beats 19.00%��=��=��=��(�b��b;)��
	 * ǰ�Ŵ��У�������ѧ��ϵ�ܹ������õ����ø��߻����Ż��ٶȡ�
	 * ��Ȼ��ǰ����Щ������������һ����Ҳ�ǲ�֪��Ϊʲô���ҿ���ô�ࣨ����
	 * 
	 * @param matrix
	 * @return
	 */
	public static boolean isToeplitzMatrix(int[][] matrix) {
        int rn = matrix.length, cn = matrix[0].length;
        for(int i = 1;i < rn ;++i) {
        	for(int j = 1;j < cn ;++j) {
        		if(matrix[i][j] != matrix[i - 1][j - 1])
        			return false;
        	}
        }
        return true;
    }
}
