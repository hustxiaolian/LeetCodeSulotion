package com.xiaolianhust.leetcode.easy;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {2,1,2,1,0,1,2}));
	}
	
	/**
	 * ��һ��˼·��
	 * �����㷨��ʹ�������������ݴ棬ǰ�ߴ洢buy�����������뱣֤��ǰһ��ֵ��С��
	 * ���ߴ洢sell�����������뱣֤��ǰһ��ֵ����
	 * 
	 * ���岽�裺
	 * 1. whileѭ��������ȷ��һ�����㣬��Сֵ��
	 * 2. �ж�������������Ҹ�sell��ʼ����ֵ
	 * 3. �˺�û����һ��ֵ���ж����Ƿ��buyVal��С������ǣ������buyVal������curr - buyVal > result��������������sellVal�����Ҹ���result
	 *
	 * test1:2ms, beats 92.30%��=��=��=��(�b��b;)��
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
	 * discuss�����˼·ʡ����ǰ��Ĳ���1���ҵĲ�����Ϊ�˱��⽵������������
	 * ��solution�����˼·��ͨ����min����Ϊһ������ֵ��Ȼ���١�����
	 * 
	 * ��Ϊʲôû�뵽�����򵥵�˼·�أ�����ϸ��ĥ�¡��Ӷ�����д�����������Ƚϸ��ӵô��롣
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
