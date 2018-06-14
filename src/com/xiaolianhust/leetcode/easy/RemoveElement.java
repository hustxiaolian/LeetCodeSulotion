package com.xiaolianhust.leetcode.easy;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ˼·����ͷ��β�����������飬����target������������β��������˵��β����Ԫ�ظ�������������һ��������¼n - 1.
	 * ���ж�����滻ԭʼ�Ƿ���val����������n - 2�滻��ֱ��������valΪֹ��
	 * ����ڲ����ڵ����ַ�ʽ�����val��ֵ����������Ԫ�ص�һ�롣��ô��ӵ�и�С���ڴ��д��������������Ϊ��
	 * ��������������ϸ�ڣ����岻��
	 * 
	 * test1:9ms, beat 99.06%(��=��=��=��(�b��b;)��)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n <= 0) return 0;
        int i;
        for(i = 0; i < n;) {
        	if(nums[i] == val) 
        		nums[i] = nums[--n];
        	else 
        		++i;
        }
        
        return n;
    }
	
	public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        if(n <= 0) return 0;
        int i, j;
        for(i = 0, j = 0; i < n;++i) {
        	if(nums[i] != val) 
        		nums[j++] = nums[i];
        }
        
        return n;
    }
}
