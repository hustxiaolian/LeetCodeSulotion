package com.xiaolianhust.leetcode.easy;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * եȡÿ�������׶ε����м�ֵ��
	 * 
	 * �ݹ�˼·����ÿ�������������׶γ�ȡ�������ݹ���жϼ�������졣
	 * ��ôresult = ������ֵ֮�͡�
	 * 
	 * test1: 2ms, beats 82.43%��=��=��=��(�b��b;)��
	 * 
	 * �����Һ��������е㸴���ˡ����±��˵�˼·��
	 * ���գ���Ŷ����ȫ���ԱȽ�����Ԫ�أ����prices[i] > price[i - 1]�Ͱ������ֵ���ϡ�
	 * ������easy���Ҹо����������븴�ӵ�˼ά���֣���һ��������ıȽϸ��ӡ�
	 * �о����̱�ѹ���ˣ�����������û�£������һ���ʹ����΢���ӵķ�ʽ��������
	 * ���ּ�����ŵĴ��룬�������ۣ��ܽ�ѡ�
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
