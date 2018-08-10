package com.xiaolianhust.leetcode.easy;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountPrimes().countPrimes2(10));
	}
	
	/**
	 * ˼·��
	 * �жϵ�ǰ�����Ƿ���prime�������f(i) = f(i-1) + 1����
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
	 * ˼·��
	 * ����discuss��˼·����������dp��˼�룬����������ظ����㡣
	 * 
	 * ������˼·�ǣ�
	 * ���ǿ����жϵ�ǰ�������Ƿ�Ϊprime��Ȼ���ʼ��һ������j�����ǽ���һ�����飬����������Ϊ
	 * ��prime�� ֱ��i*j<n
	 * Ȼ��ʼ��һ�ִΡ�
	 * 
	 * test2:22ms, beats 36.23%��=��=��=��(�b��b;)��
	 * ���ˣ���������˼·�ͷ��������񣬵��Ǿ�����Щ���������ѧ�ɡ�
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
