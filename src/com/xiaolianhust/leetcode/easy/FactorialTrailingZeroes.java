package com.xiaolianhust.leetcode.easy;

public class FactorialTrailingZeroes {
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(1));
	}
	/**
	 * 思路：
	 * 这道题我感觉就是算n之前的所有数字上有几个5的因此，也就是能被5整除几次。因为2不缺。
	 * 而2*5就是10。然后大致用dp做，检查到一个k，判断它能够被5整除，能被整除几次，比如25可以两次，125可以三次。
	 * 
	 * 编码明早再实现，实验室正式放假，今晚放松下。
	 * 
	 * test1:TLE, 可以的。牛逼。我再想想其他骚套路。
	 * 改进，中间的某些地方，就不同判断，直接5个5个的跳跃。
	 * 
	 * test2:TLE, 可怕，算了看discuss大佬的套路把。学习下。
	 * 卧槽，最高票的思路把我看湿了。不仅仅log的思路，而且有效避免了溢出的问题。
	 * 
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
        int last = 0, curr;
        
        for(curr = 5;curr <= n;curr += 5) {
        	int cnt = 0, temp = curr;
        	while(temp % 5 == 0) {
        		temp = temp / 5;
        		++cnt;
        	}
        	last = last + cnt;
        }
        
        return last;
    }
	
	/**
	 * the idea is：
	 * n / 5 表示有多少个5的因子。
	 * n / 25 表示有多个25的因子，由于这部分n / 5算过一遍了，因此只算一遍而不是两遍。
	 * 
	 * ...
	 * @param n
	 * @return
	 */
	public static int trailingZeroes2(int n) {
		return n == 0? 0: n / 5 + trailingZeroes2(n / 5);
	}
}
