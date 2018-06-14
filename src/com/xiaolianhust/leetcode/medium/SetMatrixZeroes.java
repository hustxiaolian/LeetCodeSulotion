package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
	}

	/**
	 * ��һ��˼·��
	 * һ��һ�е�����ɨ�裬ʹ��һ����������¼��Щ��Ӧ��Ϊ��Ϊ0����������׷�ݣ��Ѹñ�Ϊ0�ı����
	 * ����ʹ�ó����ռ�ķ�����ȷʵ��ʱû�뵽���ʣ���һ��˼·�������������ڶ���˼·���������Ҿ���ʵ��̫�˷�ʱ���ˡ�
	 * 
	 * �ڶ���˼·��
	 * ����ÿ��Ԫ�أ�����0����������չ��0ֱ���߽硣����ȱ������Ҳ̫��ʱ���ˡ�
	 * 
	 * ������˼·��
	 * �ο��ı���discuss������ɨ�������Ϣ��������У��൱�ڰ��ҵ�һ��˼·�ݴ�����������У��ɴ����ﵽ�����ö���
	 * �ռ��Ŀ�ġ�
	 * 
	 * bug1:�������޸ģ����¸��������û��֪��������㵽����ԭ���еģ����Ǻ����޸ĵġ�
	 * 
	 * test1:2ms, beats 92.70%��=��=��=��(�b��b;)��
	 * 
	 * �ܽᣬ��ʱ���м������һ��Ҫ�½�һ�����������棬���ǿ��Խ�����������������ء�
	 * �ؼ�����Ҫ��Ӱ�죬����˵��Ҫ�����ս���ļ����кô���
	 * 
	 * @param matrix
	 */
    public static void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	if(m == 0) return;
    	int n = matrix[0].length;
    	boolean flagFirstRow = false;
    	//��������Ƿ����㣬��λ���λ
    	for(int i = 0;i < n;++i) {
    		if(matrix[0][i] == 0) {
    			flagFirstRow = true;
    			break;
    		}
    	}
    	boolean flagCurrRow = false;
    	//��ʼ��������������
    	for(int i = 1;i < m;++i) {
    		for(int j = 0;j < n;++j) {
    			if(matrix[i][j] == 0) {
    				matrix[0][j] = 0;
    				flagCurrRow = true;
    			}
    		}
    		if(flagCurrRow) {
    			Arrays.fill(matrix[i], 0);
    			flagCurrRow = false;
    		}
    	}
    	
    	for(int j = 0;j < n; ++j) {
    		if(matrix[0][j] == 0) {
    			for(int k = 1;k < m;++k)
    				matrix[k][j] = 0;
    		}
    	}
    	
    	if(flagFirstRow)
    		Arrays.fill(matrix[0], 0);
    }
}
