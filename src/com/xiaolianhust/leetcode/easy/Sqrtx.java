package com.xiaolianhust.leetcode.easy;

public class Sqrtx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt2(Integer.MAX_VALUE));
	}
	
	/**
	 * ��һ��˼·��
	 * ������ֵ�����еĶ��ַ����𽥱ƽ��м�Ľ���ֵ��֪��left��right < 1��˵��������
	 * 
	 * test1:52ms, beat 18.55%��=��=��=��(�b��b;)��
	 * 
	 * �ڶ���˼·��
	 * ʹ��while����ȡ���ݹ顣
	 * 
	 * test2:47ms, beats 48.69% ��=��=��=��(�b��b;)��
	 * 
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		if(x <= 1) return x;
        return helper(0,46500,x);
    }

	private static int helper(int left, int right, int x) {
		if(right - left <= 1)
			return left;
		int mid = (left + right) / 2;
		int temp = mid * mid;
		if(temp < 0)
			return helper(left, mid, x);
		if(temp < x)//ע�⵽����x��int-��long���Զ�ת��
			return helper(mid, right, x);
		else if(temp > x)
			return helper(left, mid, x);
		else 
			return mid;
	}
	
	public static int mySqrt2(int x) {
		int left = 0, right = 46500;
		while(left + 1 < right) {
			int mid = (left + right) / 2;
			long temp = mid * mid;
			if(temp < 0 || temp > x)
				right = mid;
			else if(temp < x)
				left = mid;
			else 
				return mid;
		}
		
		return left;
	}
	
	public static int mySqrt3(int x) {
		return (int)(Math.pow(x, 0.5));
	}

}
