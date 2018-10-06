package com.xiaolianhust.leetcode.review;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ������Ҽǵ��൱�ľ��䣬���ҵ�һ��ѧϰ�˴��������м������
	 * �ܵ�˼·���Ȱѿ��������Ȼ��˫ָ����������м������
	 * ÿ�αȽ����ҵĸ߶ȣ��ƶ��͵��Ǳߣ���Ϊ�ƶ��ߵ��Ǳ߸���û�����塣
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        
        while(left < right) {
        	max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        	if(height[left] > height[right])
        		--right;
        	else
        		++left;
        }
        
        return max;
    }
}
