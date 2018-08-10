package com.xiaolianhust.leetcode.easy;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountPrimes().countPrimes2(10));
	}
	
	/**
	 * 思路：
	 * 判断当前数字是否是prime，如果是f(i) = f(i-1) + 1即可
	 * 
	 * test1:553ms, beats 4.72%
	 * @param n
	 * @return
	 */
	
	static boolean[] dict = new boolean[10];
	static {
		dict[1] = true;
		dict[3] = true;
		dict[7] = true;
		dict[9] = true;
	}
	
    public int countPrimes(int n) {
    	int curr = 2, count = 0;
    	for(;curr < 10;++curr) {
    		if(isPrime(curr))
    			count++;
    	}
    	for(;curr < n;++curr) {
    		if(dict[curr % 10] && isPrime(curr))
    			count++;
    	}
    	return count;
    }

	private boolean isPrime(int curr) {
		int end = (int) Math.sqrt(curr);
		int n = 2;
		while(n <= end) {
			if(curr % n++ == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * 思路：
	 * 看了discuss的思路，他们利用dp的思想，避免大量的重复计算。
	 * 
	 * 其具体的思路是：
	 * 我们可以判断当前的数字是否为prime后，然后初始化一个倍数j，我们建立一个数组，标记这个数字为
	 * 非prime， 直到i*j<n
	 * 然后开始下一轮次。
	 * 
	 * test2:22ms, beats 36.23%ε=ε=ε=┏(゜ロ゜;)┛
	 * 算了，明明代码思路和方法都很像，但是就是慢些，这就是玄学吧。
	 * 
	 * @param n
	 * @return
	 */
	public int countPrimes2(int n) {
		boolean[] tmp = new boolean[n];
		int count = 0;
		for(int i = 2;i < n;++i) {
			if(!tmp[i]) {
				++count;
				for(int j = i << 1;j < n;j += i)
					tmp[j] = true;
			}
		}
		return count;
	}
}
