package com.xiaolianhust.leetcode.medium;

public class UglyNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ������ĿҪ�����ֵ�����ֻ��Ϊ2.��3��5����ô�����ֱ�Ȼ��2*x��3*y*,5*z��Ȼ��������������˶�����
	 * ����x��y,zΪ����������ô��Ŀ�ͱ��3������鲢����������ˡ�����ԡ�
	 * ͬʱ������Ӧ��ע�⵽�ظ����⡣�ȱ�֤��һ��������ԶҪ���ڡ�
	 * 
	 * test1: 5ms, beats 50.16%��=��=��=��(�b��b;)��
	 * 
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        if(n <= 6)
        	return n;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int next2 = 2, next3 = 3, next5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        
        for(int i = 1;i < n;++i) {
        	int currMin = Math.min(Math.min(next2, next3), next5);
        	ugly[i] = currMin;
        	if(currMin == next2)
        		next2 = 2 * ugly[++index2];
        	if(currMin == next3)
        		next3 = 3 * ugly[++index3];
        	if(currMin == next5)
        		next5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
