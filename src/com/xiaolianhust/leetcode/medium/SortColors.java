package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {2,0,2,1,1,0};
		sortColors(c);
		System.out.println(Arrays.toString(c));
	}
	/**
	 * ˼·��
	 * ���Ȱ���counting sort�ķ�ʽ����һ�飬�ع˸�ϰ�»�������
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
        int[] colorNum = new int[3];
        int n = nums.length;
        for(int i = 0;i < n;++i) {
        	switch (nums[i]) {
			case 0: ++colorNum[0];break;
			case 1: ++colorNum[1];break;
			case 2: ++colorNum[2];break;
			}
        }
        for(int i = 0, index = 0;i < 3;++i) {
        	int currNum = colorNum[i];
        	for(int j = 0;j < currNum;++j,++index) {
        		nums[index] = i;
        	}
        }
    }
	
	/**
	 * �������뵽����˼·�����ǻ��ǽ����ڽ�����ǰ���£�û���뵽����666�ķ�����лл��ѧϰ�ˡ�
	 * ����ٴθ�ϰ���¿��ŵ�lumuto partition�㷨��
	 * ����ָ��i,j,iָ��ǰ��>pivot��λ�ã�jһ��ʼ����ͬһλ�ã�j��ǰ��������if(nums[j] <= pivot)
	 * ��ô����i��jλ�õ�Ԫ�أ�Ȼ��i++��������֤��ǰ�벿��һ����<=pivot��Ԫ�ء�лл��
	 * @param nums
	 */
	public static void sortColors2(int[] nums) {
		int redIndex = 0,whiteIndex = 0, n = nums.length;
		for(int i = 0;i < n;++i) {
			int temp = nums[i];
			nums[i] = 2;
			if(temp < 2)
				nums[whiteIndex++] = 1;
			if(temp == 0)
				nums[redIndex++] = 0;
		}
	}
}
