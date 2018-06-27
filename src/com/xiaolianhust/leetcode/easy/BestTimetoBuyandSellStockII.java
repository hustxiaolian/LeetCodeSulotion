package com.xiaolianhust.leetcode.easy;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 榨取每个上升阶段的所有价值。
	 * 
	 * 递归思路：将每个这样的上升阶段抽取出来，递归地判断检查这样快。
	 * 那么result = 各上升值之和。
	 * 
	 * test1: 2ms, beats 82.43%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 不过我好像做的有点复杂了。看下别人的思路。
	 * 我日，对哦，完全可以比较相邻元素，如果prices[i] > price[i - 1]就把这个差值加上。
	 * 这两道easy，我感觉我容易陷入复杂的思维僵局，将一个问题想的比较复杂。
	 * 感觉智商被压制了，哈哈，不过没事，起码我还是使用稍微复杂的方式做出来。
	 * 这种简洁优雅的代码，慢慢积累，总结把。
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        int n = prices.length;
		if(n <= 1) return 0;
		return helper(prices, 0, n);
    }

	private int helper(int[] prices, int startIndex, int n) {
		if(n - startIndex <= 1) return 0;
		
		int buyVal = 0, i;
		for(i = startIndex + 1;i < n;++i) {
			if(prices[i] > prices[i - 1]) {
				buyVal = prices[i - 1];
				break;
			}
		}
		if(i == n) return 0;
		int sellVal = 0;
		for(;i < n;++i) {
			if(prices[i] < prices[i - 1]) {
				sellVal = prices[i - 1];
				break;
			}
		}
		if(i == n)
			return prices[n - 1] - buyVal;
		
		return (sellVal - buyVal) + helper(prices, i, n);
	}
	
	public int maxProfit2(int[] prices) {
		int result = 0;
		int n = prices.length;
		for(int i = 1;i < n;++i) {
			int temp = prices[i] - prices[i - 1];
			if(temp > 0)
				result += temp;
		}
		return result;
	}

}
