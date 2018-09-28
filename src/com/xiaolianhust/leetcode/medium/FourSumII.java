package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class FourSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：
	 * 最粗暴的思路：
	 * 四个for循环。
	 * 
	 * 
	 * 改进思路：
	 * 将最里面两层for改成，从两端向中间遍历的形式。
	 * 
	 * 看了discuss的思路，
	 * 我tm真是发现自己智商下降了。日。
	 * 直接一个hashmap，然后计算A，B的所有情况，键为sum，值为出现的次数。
	 * 
	 * 然后再使用前面存储的hashmap，for+for遍历C，D，判断即可。。。
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int n = A.length;
		if(n == 0) return 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int sum = 0, result = 0;
        int min1 = D[0], min2 = min1 + C[0], min3 = min2 + B[0];
        int max1 = D[n - 1], max2 = max1 + C[n - 1], max3 = max2 + B[n - 1];
        for(int i = 0;i < n;++i) {
        	if(A[i] > -min3 || A[i] < -max3) break;
        	sum = A[i];
        	for(int j = 0;j < n;++j) {
        		if(sum + B[j] > -min2 || sum + B[j] < -max2) break;
        		sum += B[i];
        		for(int p = 0;p < n;++p) {
        			if(sum + C[p] > -min1 || sum + C[p] < -max1) break;
        			sum += C[p];
        			for(int q = 0; q < n;++q) {
        				if(sum + D[q] == 0)
        					++result;
        				else if(sum + D[q] > 0)
        					break;
        			}
        			sum -= C[p];
        		}
        		sum = A[i];
        	}
        }
        return result;
    }
	
	/**
	 * 思路：
	 * 参考大佬hashmap的思路。
	 * 
	 * test1: 141ms
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	HashMap<Integer, Integer> map = new HashMap<>();
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		int n = A.length, result = 0;
		for(int i = 0;i < n;++i) {
			for(int j = 0;j < n;++j) {
				int currSum = A[i] + B[j];
				int tmp = map.getOrDefault(currSum, 0);
				map.put(currSum, tmp + 1);
			}
		}
		
		for(int i = 0;i < n;++i) {
			for(int j = 0;j < n;++j) {
				result += map.getOrDefault(-(C[i] + D[j]), 0);
			}
		}
		return result;
	}
}
