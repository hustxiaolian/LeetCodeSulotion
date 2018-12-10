package com.xiaolianhust.leetcode.review;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveElement().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}
	
	/**
	 * ˼·��
	 * �����������飬��������ɾ����Ԫ��ʱ��ȡ����ǰ��������һ��Ԫ�أ������������ҽ����鳤�ȼ�¼����-1
	 * 
	 * test1:8ms, beats 19.13%
	 * 
	 * ������˼·��˫ָ�룬i�����������飬jֻ�е�nums[i] != valʱ��¼���ƶ����������ַ�ʽ�����Ա�֤����Ԫ�ص����λ�ò��䡣
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        for(int i = 0;i <= tail;) {
        	if(nums[i] == val) {
        		nums[i] = nums[tail--];
        	} else {
        		++i;
        	}
        }
        return tail + 1;
    }
	
	/**
	 * ˫ָ�뷽��
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
		int j = 0;
		for(int i = 0; i < nums.length;++i)
			if(nums[i] != val)
				nums[j++] = nums[i];
		return j;
	}
}
