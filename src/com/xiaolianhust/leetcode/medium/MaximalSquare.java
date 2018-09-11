package com.xiaolianhust.leetcode.medium;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * �����û����������ο���discuss��˼·���ܽ��£�
	 * 1. ����Ҫȷ��dp�Ķ�������dp���ǵ�ǰ�ڵ㼰�������������������εı߳�������������֪ǰ������
	 * 2. ���ݵ�ǰ�������ж�.
	 * 		���ȵ�ǰλ�ñ���Ϊ1�� Ȼ���������Ҫ�������ţ���ô���Ҫ��֤���ϣ����£����������붼�ǡ�1��
	 *      �����������Σ���˱߳���ֵ�����ȡ���ߵ���Сֵ��
	 *      f(i,j) = f(i-1,j) + f(i,j-1) + f(i-1,j-1)
	 * 
	 * ����һ�ֲ����˼·���ٿ����������е�˼·����ѧϰ�����ܽᡣ������˼��
	 *      
	 * �������е�˼·Ҳ�������࣬����˼·ֵ�úú�ѧϰ��ͬʱ����֮ǰ��·�������ϵ��ǣ�
	 * 1. ����ȷ��dp��ʽ�еĶ�����ʲô��������ǡ��������½�(i,j)�ڵ�����������εı߳���
	 * 2. ����ǰ��Ľ������֪�����ݵ�ǰ��������д�ݹ�ʽ���������ֵ�úú�ѧϰ�ľ��ǣ�����С��ʾ���������ܽ���ɣ�Ȼ����֤��һ��Ĵ�����Ρ�
	 * 3. ���Ǳ߽����ε����������
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;++i) {
        	for(int j = 1;j <= n;++j) {
        		if(matrix[i - 1][j - 1] == '1') {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        return max * max;
    }
}
