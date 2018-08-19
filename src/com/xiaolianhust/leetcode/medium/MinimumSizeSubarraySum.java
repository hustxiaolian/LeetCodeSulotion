package com.xiaolianhust.leetcode.medium;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}
	
	/**
	 * ��һ��˼·��
	 * �򵥣��ֱ��ķ�����
	 * ���ȶ���һ������Ϊ1�Ĵ��ڣ�Ȼ��������Ҽ��㴰���ں�ֵ������target��ֱ�ӷ��ء�
	 * �����������ν����ڳ��ȱ�Ϊ2��3��4....
	 * �����������ظ����㡣
	 * 
	 * �Ľ��Դֱ�˼·�����Ƕ���һ�����ȿɱ�Ļ�������,������ָ��ָ���������˱�����
	 * �����ں�ֵ���˾�left++����ֵС�˾�right++�����ھ��жϼ�¼��
	 * 
	 * test1:4ms, beats 20.50%��=��=��=��(�b��b;)��
	 * 
	 * �Ľ�˼·��
	 * ��ʵֻ�����������ʱ�򣬲���Ҫ��¼��Ҳ��˵����ʡ��Math.min�Ĳ���������
	 * �������󣬿�����
	 * 
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int result = n + 1;
        int left = 0, right = 0, windowSum = 0;
        //���ڻ���
        while(right < n) {
        	if(left == right || windowSum < s) {
        		windowSum += nums[right++];
        	}
        	else {
        		result = Math.min(result, right - left);
        		if(windowSum > s)
        			windowSum -= nums[left++];
        		else
        			windowSum += nums[right++];
        	}
        }
        //�������ĩβ������,�ж�ĩβ�Ƿ�����Ҫ���ܵ������顣
        if(windowSum >= s) {
        	while(left < n) {
            	if(windowSum >= s) 
            		result = Math.min(result, right - left);
            	else
            		break;
        		windowSum -= nums[left++];
            }
        }
        
        //�ж��Ƿ���һ���Ϸ��������顣
        if(result == n + 1)
        	return 0;
        return result;
    }
}
