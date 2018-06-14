package com.xiaolianhust.leetcode.hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = {1,3};
		int[] n = {2};
		
		System.out.println(findMedianSortedArrays(m, n));
	}
	/**
	 * ˼·����Ȼ�Ƕ��������ı��֡��ؼ��������������������ʵ�ֶ���������
	 * 20������û���������������𰸡�
	 * 
	 * ��ȥ��ԭ������ֵ���������������ġ���ν��ֵ��
	 * Dividing a set into two equal length subsets, that one subset is always greater than the other.
	 * 
	 * ��ô��������ѧ�������ǣ�
	 * 1. ��ֵ���ߵļ��ϴ�С = ��ֵ�Ұ�߼��ϵĴ�С
	 * 2. ���ߵ����ֵ <= �Ұ�ߵ���Сֵ
	 * medium = [max(left) + min(right)] /2;
	 * 
	 * �ɴˣ����Ǽ����һ��������m��Ԫ�أ��ڶ���������n��Ԫ�أ�A[i-1],A[i],B[j-1],B[j]
	 * i + j = m - i + n - j => if n >= m, j = (m + n + 1) /2 - 1;
	 * B[j - 1] <= A[i] and A[i - 1] <= B[j];
	 * 
	 * �ɴ�˼·�����ڵ�һ������������i����������������ɡ�
	 * 
	 * test:65ms ,beats 95.82%����=��=��=��(�b��b;)��
	 * 
	 * �����˼·�൱���أ�������Ҫע���ϸ��Ҳ�Ƚ϶ֵ࣬�÷������ѧϰ��
	 *  
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m, n;
		int[] A, B;
		
		if(nums1.length > nums2.length) {
			A = nums2;
			B = nums1;
		}
		else {
			A = nums1;
			B = nums2;
		}
		m = A.length;
		n = B.length;
		
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;//����+1��ԭ��������i,j����ָ���Ұ�߼��ϡ�
		while(iMin <= iMax) {
			int i = (iMax + iMin) / 2;
			int j = halfLen - i;
			//ʹ�ö��ַ�����
			if(i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1;
			}
			else if(i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1;
			}
			else {
				int maxLeft = 0;
				if(i == 0)	
					maxLeft = B[j - 1];
				else if(j == 0)
					maxLeft = A[i - 1];
				else 
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				if((m + n) % 2 == 1) return maxLeft;
				
				int minRight = 0;
				if(i == m)
					minRight = B[j];
				else if(j == n)
					minRight = A[i];
				else
					minRight = Math.min(A[i], B[j]);
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		
        return 0.0;
    }
}
