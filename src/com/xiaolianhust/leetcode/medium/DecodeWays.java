package com.xiaolianhust.leetcode.medium;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("1212"));
	}
	/**
	 * �Ϲ�أ����ܽ������ʽ��д������ʽ���ٶ���.
	 * �������Ȼ�����������ǻ����е㶪����,��Ϊ���˴�������·��
	 * test1: 1ms, beats 99.77%
	 * 
	 * �ܽᾭ��ͽ�ѵ��
	 * ���飺
	 * 1. ���ڶ�����dp�ĺ���˼·�����ϱȽ������ˣ��ٶ���׼�����������������ۣ�����Ǳ߽硣
	 * 
	 * ��ѵ��
	 * 1. ��������۵�ʱ������ɣ����ǵĲ���ϸ���ܵ������ǵ�̫ǳ��û�������70%֮���ٶ��֡�
	 * ��Ȼ��Ҳ����Ϊ����������Ȳ����ԭ��
	 * 
	 * �����������൱���ģ��Ƚ�ʱ����޺�Ч�ʺܸߣ�ֵ�ÿ϶��������ٽ���������������ȣ����Ǹ�����ϸ��
	 * 
	 * dp˼·��
	 * 1. �ٶ���׼����
	 * ������֪��f[0..i-1]����֮ǰ��ֵ����f[0...i-2]
	 * 
	 * 2. ��������۵�ǰ�����
	 * 2a.�жϷǷ���������޷��γ���ȷ�����֣���s[i]=0,����s[i-1]����1����2��ֱ�ӷ���0��ʾ����
	 * 2b.��s[i]=0ʱ���Ҳ��Ƿ�ʱ�����ض�ֻ�ܺ�ǰ���ϣ���s[i] = s[i-2]����Ϊ�������ˣ�ֻ����ô���
	 * 2c.��s[i-1]=1,s[i]=1-9����s[i-1]=2,s[i]=1-6ʱ��s[i] = s[i-1]+1
	 * 2d.�����϶��޷�����ʱ����ʾ������ֻ��׷��һ��Ԫ�أ��������,s[i]=s[i-1]
	 * 
	 * �߽�����
	 * 1.����ĸΪ0���Ƿ�ֱ��0
	 * 2.����ĸ������ɶ������1��f(s[0]) = 1
	 * 3.Ϊ�����10����20�����������Σ�f(s[-1])=1
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		int sn = s.length();
        int[] arr = new int[sn + 1];
        if(s.charAt(0) == '0') return 0;
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 1;i < sn;++i) {
        	char curr = s.charAt(i);
        	char last = s.charAt(i - 1);
        	if(curr == '0' && (last >= '3' || last == '0'))
        		return 0;
        	else if(curr == '0')
        		arr[i+1] = arr[i - 1];
        	else if((last == '1')|| (last == '2' && curr <= '6'))
        		arr[i+1] = arr[i] + arr[i-1];
        	else
        		arr[i+1] = arr[i];
        }
        return arr[sn];
    }
}
