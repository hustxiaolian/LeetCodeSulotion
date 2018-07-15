package com.xiaolianhust.leetcode.medium;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("1212"));
	}
	/**
	 * 老规矩，先总结出归纳式后，写出归纳式后再动手.
	 * 这道题虽然做出来，但是还是有点丢脸的,因为走了大量的弯路。
	 * test1: 1ms, beats 99.77%
	 * 
	 * 总结经验和教训：
	 * 经验：
	 * 1. 现在对这种dp的核心思路基本上比较明白了，假定基准，根据题意分情况讨论，最后考虑边界。
	 * 
	 * 教训：
	 * 1. 分情况讨论的时候急于求成，考虑的不够细致周到，考虑得太浅，没有想清楚70%之后再动手。
	 * 当然，也是因为经验和熟练度不足的原因。
	 * 
	 * 能做出来，相当开心，比较时间界限和效率很高，值得肯定，后面再接再厉，提高熟练度，考虑更加仔细。
	 * 
	 * dp思路：
	 * 1. 假定基准情形
	 * 假设我知道f[0..i-1]及其之前的值，即f[0...i-2]
	 * 
	 * 2. 分情况讨论当前的情况
	 * 2a.判断非法情况，即无法形成正确的数字，即s[i]=0,但是s[i-1]不是1或者2，直接返回0表示错误
	 * 2b.当s[i]=0时，且不非法时，它必定只能和前面结合，则s[i] = s[i-2]，因为它钉死了，只能这么结合
	 * 2c.当s[i-1]=1,s[i]=1-9或者s[i-1]=2,s[i]=1-6时，s[i] = s[i-1]+1
	 * 2d.当以上都无法满足时，表示它仅仅只能追加一个元素，结果不变,s[i]=s[i-1]
	 * 
	 * 边界情形
	 * 1.首字母为0，非法直接0
	 * 2.首字母无论是啥，都是1，f(s[0]) = 1
	 * 3.为了配合10或者20这种特殊情形，f(s[-1])=1
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
