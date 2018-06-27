package com.xiaolianhust.leetcode.easy;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {2,1,2,1,0,1,2}));
	}
	
	/**
	 * 第一种思路：
	 * 线性算法，使用两个变量来暂存，前者存储buy，更新它必须保证比前一个值更小，
	 * 后者存储sell，更新它必须保证比前一个值更大。
	 * 
	 * 具体步骤：
	 * 1. while循环，首先确定一个极点，极小值。
	 * 2. 判断特殊情况，并且给sell初始化赋值
	 * 3. 此后没遍历一个值，判断它是否比buyVal更小。如果是，则更新buyVal；或者curr - buyVal > result更大，如果是则更新sellVal，并且更新result
	 *
	 * test1:2ms, beats 92.30%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if(n <= 1)	return 0;
		int i;
		int buyVal = 0;
		
		for(i = 1;i < n;++i) {
			if(prices[i] > prices[i - 1]) {
				buyVal = prices[i - 1];
				break;
			}
		}
		
		if(i == n) return 0;
		int sellVal = prices[i++];
		int result = sellVal - buyVal;

		for(;i < n;++i) {
			int curr = prices[i];
			if(curr < buyVal) 
				buyVal = curr;
			else if(curr - buyVal > result)
				result = curr - buyVal;
		}
        return result;
    }
	
	/**
	 * discuss里面的思路省略我前面的步骤1，我的步骤是为了避免降序的特殊情况，
	 * 而solution里面的思路是通过将min设置为一个极大值，然后再。。。
	 * 
	 * 我为什么没想到这样简单的思路呢，得仔细琢磨下。从而导致写出上述那样比较复杂得代码。
	 * @param prices
	 * @return
	 */
	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		int result = 0;
		int minPrice = Integer.MAX_VALUE;
		int curr;
		for(int i = 0;i < n;++i) {
			curr = prices[i];
			if(curr < minPrice)
				minPrice = curr;
			else if(curr - minPrice > result)
				result = curr - minPrice;
		}
		return result;
	}

}
