package com.xiaolianhust.leetcode.easy;

public class FactorialTrailingZeroes {
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(1));
	}
	/**
	 * ˼·��
	 * ������Ҹо�������n֮ǰ�������������м���5����ˣ�Ҳ�����ܱ�5�������Ρ���Ϊ2��ȱ��
	 * ��2*5����10��Ȼ�������dp������鵽һ��k���ж����ܹ���5�������ܱ��������Σ�����25�������Σ�125�������Ρ�
	 * 
	 * ����������ʵ�֣�ʵ������ʽ�ż٣���������¡�
	 * 
	 * test1:TLE, ���Եġ�ţ�ơ�������������ɧ��·��
	 * �Ľ����м��ĳЩ�ط����Ͳ�ͬ�жϣ�ֱ��5��5������Ծ��
	 * 
	 * test2:TLE, ���£����˿�discuss���е���·�ѡ�ѧϰ�¡�
	 * �Բۣ����Ʊ��˼·���ҿ�ʪ�ˡ�������log��˼·��������Ч��������������⡣
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
	 * the idea is��
	 * n / 5 ��ʾ�ж��ٸ�5�����ӡ�
	 * n / 25 ��ʾ�ж��25�����ӣ������ⲿ��n / 5���һ���ˣ����ֻ��һ����������顣
	 * 
	 * ...
	 * @param n
	 * @return
	 */
	public static int trailingZeroes2(int n) {
		return n == 0? 0: n / 5 + trailingZeroes2(n / 5);
	}
}
