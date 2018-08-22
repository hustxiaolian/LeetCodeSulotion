package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(countBits2(5)));
	}
	
	/**
	 * 思路：
	 * 由于bit二进制不停加1的特殊性质，两个bit时，将最前面那个bit看成1，然后其实后续的bit的位数的变化规律都是一样的。
	 * 比如0-1 = [0,1]
	 * 2 - 3 = [0,1] + 1 =[1,2]
	 * 4 - 7 = [1, 2, 2, 3]
	 * ...依次迭代下去。
	 * 
	 * 
	 * 可以，一次过。可惜有点慢，
	 * test1:3ms, beats 17.33% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 大佬的思路跟我一样，但是他们的内循环更加紧凑，简洁。
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
