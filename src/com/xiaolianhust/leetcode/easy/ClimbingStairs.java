package com.xiaolianhust.leetcode.easy;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(4));
	}
	
	/**
	 * ��һ��˼·��
	 * �ݹ�+for����ǰ���˼·���񣬶���Ҳû��ȥ�������鷳��.
	 * 
	 * ˼·����ȷ�ģ�����ͬ����time executed out��ʱ�ˡ�
	 * ԭ����ô�ݹ�ȷʵ������������Ч����Ҫ�����д����ظ��ļ���
	 * 
	 * 
	 * �ڶ���˼·��
	 * ��ϸ��ĥ�£���ʵ���Ҹо���һ��������ϵ�����
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	return path(0, n, 0);
    }

	private static int path(int curr, int end, int cnt) {
		if(curr == end)
			return 1;
		int temp = 0;
		if(curr < end)
			temp = path(curr + 1, end, cnt);
		if(curr + 1 < end)
			temp += path(curr + 2, end, cnt);
		return temp;
	}
    
	/**
	 * �ڶ���˼·��
	 * �����Ǹ���������Ǵ������õļ��㣬�˷�ʱ�䡣
	 * ��ˣ�����ʹ��һ������ȥ��¼��
	 * @param n
	 * @return
	 */
	public static int climbStairs2(int n) {
		int[] mem = new int[n];
		return path2(0, n, mem);
	}

	private static int path2(int i, int n, int[] mem) {
		//��׼����
		if(i > n)
			return 0;
		if(i == n)
			return 1;
		if(mem[i] > 0)
			return mem[i];
		mem[i] = path2(i + 1, n, mem) + path2(i + 2, n, mem);
		return mem[i];
	}
	
	/**
	 * ������˼·��������˴𰸵�˼·���������ѵ�����ڱ���Ҫ������������ǰ��֮�����ֹ�ϵ��
	 * ��̬�滮����ʵ��ϸ�����Ŀ����ʵ���ǿ��Է��֣�
	 * d[p] = d[p - 1] + d[p - 2]
	 * Ϊʲô�������أ�������ϸ�����Ŀ�����Է��֣�
	 * �ﵽp�����Դ��ֻ�п�����������һ����p - 1��������һ����һ����p - 2��������2����
	 * �����˿��ܻ��ʣ���Ϊʲôû����p - 2������1����1���ķ�ʽ�أ���Ϊ������p - 1��������һ�����֣�һ���ġ�
	 * 
	 * test1:4ms, beast 98.62%��=��=��=��(�b��b;)��
	 * @param n
	 * @return
	 */
	public static int climbStairs3(int n) {
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		
		int first = 1, second = 2;
		int result = 0;
		for(int i = 3;i <= n;++i) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	} 

}
