package com.xiaolianhust.leetcode.easy;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * ˼·��
	 * �趨����ָ������������ݴ�С����ǰ��Ȼ��һ�����
	 * 
	 * test1:5ms, beats 99.91%��=��=��=��(�b��b;)��
	 * 
	 * 
	 * �����һ��Ǿ���discuss������Ǹ�˼·���á�
	 * ����һ�£���ʱ����Ҫ�����temp�ˡ����
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0,j = 0,k = 0;
        int[] result = new int[m + n];
        
        while(i < m && j < n) {
        	if(nums1[i] < nums2[j])
        		result[k++] = nums1[i++];
        	else
        		result[k++] = nums2[j++];
        }
        while(i < m)
        	result[k++] = nums1[i++];
        while(j < n)
        	result[k++] = nums2[j++];
        
        for(k = 0;k < m+n;++k)
        	nums1[k] = result[k];
    }
    
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
    	int k = m + n - 1;
    	--m;--n;
    	while(m >= 0 && n >= 0) {
    		if(nums1[m] > nums2[n])
    			nums1[k--] = nums1[m--];
    		else
    			nums1[k--] = nums2[n--];
    	}
    	while(m >= 0)
    		nums1[k--] = nums1[m--];
    	while(n >= 0)
    		nums1[k--] = nums2[n--];
    }
}
