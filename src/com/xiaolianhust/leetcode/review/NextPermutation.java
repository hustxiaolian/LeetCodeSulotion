package com.xiaolianhust.leetcode.review;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,1};
		new NextPermutation().nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * ˼·��
	 * 1. �����λ���� > ʮλ���֣���ôֱ�ӽ������߼��ɡ�
	 * 2. ��������£�һ�ɰ������¹���
	 * 	a. �Ӹ�λ����λ�������������ڵ����֣���ߵ����ֵô����ұ�λ�õ����֡��������������������������������ʱ������ı���ͣ��
	 *     �����������������ֵ�λ��Ϊi,j. i=j+1.
	 *  b. Ȼ��j���ұ�����ֱ��nums[j] < nums[i] ����j == nͣ�¡�
	 *  c. �½���������p = i + 1, q = n -1,���ߴ��������м��������������λ���ϵ�Ԫ�ء�
	 *  d. ��󣬽��� λ��i��λ��((i+1)+tail)-(j-1)=tail+i-j+2��Ԫ�ؼ��ɡ�
	 *  
	 *  ps:��Ҫ���ǵ���������Ǹ��ܶࡣ
	 *  
	 *  test1:18ms, beats 9.75% ��=��=��=��(�b��b;)��
	 *  
	 *  �����Ҷ����ˣ���ȫ�����Ƚ���Ԫ�أ���ֱ�ӵ��ã���û��ô������ˡ���
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
        int tail = nums.length - 1;
        if(tail == 0)
        	return;
        else if(tail == 1 && nums[tail] >= nums[tail - 1]) {
        	exchange(nums, tail, tail - 1);
        	return;
        }
        
        int i = tail - 1,j;
        while(i >= 0 && nums[i] >= nums[i + 1])
        	--i;
        //�����������
        j = i + 1;
        if(i != -1) {
            while(j <= tail && nums[j] > nums[i])//���ܵ���
            	++j;
        }
        int p = i + 1, q = tail;
        while(p < q) {
        	exchange(nums, p, q);
        	++p;--q;
        }
        if(i != -1)
        	exchange(nums, i, tail + i - j + 2);
    }
	
	/**
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	public void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * ��ʵ������汾���������������Ǹ�˼·�ĸĽ��棬˼·��������˳������Ч���Ͳ�һ���ˣ����Ҽ�����������жϡ���
	 * @param nums
	 */
	public void nextPermutation2(int[] nums) {
		int i = nums.length - 2;
		while(i >= 0 && nums[i] >= nums[i + 1])
			--i;
		if(i >= 0) {
			int j = nums.length - 1;
			while(nums[j] <= nums[i])
				--j;
			exchange(nums, i, j);
		}
		int p = i + 1, q = nums.length - 1;
		while(p < q) {
			exchange(nums, p, q);
			++p;--q;
		}
	}
}
