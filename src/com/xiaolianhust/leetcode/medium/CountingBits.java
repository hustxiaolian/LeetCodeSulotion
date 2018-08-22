package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(countBits2(5)));
	}
	
	/**
	 * ˼·��
	 * ����bit�����Ʋ�ͣ��1���������ʣ�����bitʱ������ǰ���Ǹ�bit����1��Ȼ����ʵ������bit��λ���ı仯���ɶ���һ���ġ�
	 * ����0-1 = [0,1]
	 * 2 - 3 = [0,1] + 1 =[1,2]
	 * 4 - 7 = [1, 2, 2, 3]
	 * ...���ε�����ȥ��
	 * 
	 * 
	 * ���ԣ�һ�ι�����ϧ�е�����
	 * test1:3ms, beats 17.33% ��=��=��=��(�b��b;)��
	 * 
	 * ���е�˼·����һ�����������ǵ���ѭ�����ӽ��գ���ࡣ
	 * @param num
	 * @return
	 */
	public static int[] countBits(int num) {
		int[] result = new int[num + 1];
		for(int i = 1, curr2Pow = 1;i <= num; curr2Pow *= 2) {
			for(int j = 0;j < curr2Pow && i <= num;++j,++i)
				result[i] = result[i - curr2Pow] + 1;
		}
		return result;
    }
	
	public static int[] countBits2(int num) {
		int[] result = new int[num + 1];
		for(int i = 1, border = 1 ,prei = 1;i <= num;++i) {
			if(i == border) {
				result[i] = 1;
				border <<= 1;
				prei = 1;
			}
			else
				result[i] = result[prei++] + 1;
		}
		return result;
	}
}
