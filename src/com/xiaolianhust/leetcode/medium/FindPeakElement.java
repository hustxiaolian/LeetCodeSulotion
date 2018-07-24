package com.xiaolianhust.leetcode.medium;

public class FindPeakElement {
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {Integer.MIN_VALUE}));
	}
	
	/***
	 * ˼·��
	 * ���⣺���ڵ��������ֱض�����ͬ��Ȼ��nums[-1]�Լ�nums[n]���Ǹ������
	 * ͬʱ����ĿҪ�������log��ʱ�临�Ӷȡ�
	 * 
	 * �뵽�ĵ�һ��˼·��
	 * 1. ���ַ�ȡ�м��ֵ�������ֵ��Χ������������״̬����nums[i-1] <nums[i] < nums[i+1]
	 * 		��ô���߼���������Ϊ��Ѱ��ɽ�壬Ӧ�������·�������,���ұߵ���
	 * 2. ͬ�������������Χ������������״̬����nums[i-1]>nums[i]>nums[i+1]������ߵ�����
	 * 3. ���nums[i]�պ�����peak����nums[i-1]<nums[i] && nums[i]>nums[i+1]
	 * 4. ͬʱ���иպ��ڲ��ȵ��������ô��ѡһ��������е�����
	 * 
	 * test1:3ms, beats 99.86%��=��=��=��(�b��b;)��
	 * 
	 * @param nums
	 * @return
	 */
	public static int findPeakElement(int[] nums) {
        int result = -1;
        int n = nums.length, left = 0, right = n - 1;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	long midLeft = mid - 1< 0?Long.MIN_VALUE : nums[mid - 1];//����Ϊ�˷�ֹ���˶�������Integer.MIN_VALUE,���³����߼����⣬ֱ��ʹ��long
        	long midRight = mid + 1>= n?Long.MIN_VALUE : nums[mid + 1];
        	int midVal = nums[mid];
        	
        	if(midLeft < midVal) {
        		if(midVal < midRight) //����
        			left = mid + 1;
        		else //��ֵ
        			return mid;
        	}
        	else //���Ⱥ����ºϲ���һ�����
        		right = mid - 1;
        }
        return result;
    }
}
