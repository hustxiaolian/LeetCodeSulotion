package com.xiaolianhust.leetcode.medium;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));
	}
	
	/**
	 * 第一种思路：
	 * 使用一个hashMap，然后线性扫描过去，然后依次扫描map，检查谁只出现了一次。
	 * 算了，这种思路没有意义，这道题的难点和有意思的地方就在于使用常数空间。
	 * 
	 * 第二种思路：
	 * 使用discuss里面那种通用解法，借鉴在数据逻辑电路的知识来完成。
	 * 借鉴singleNumber的思路，如果相同的数字“异或”三次后可以回到自己的起点。
	 * 因此我们需要自己构建这样的运算，也就是将每个位看成有三种状态，也就是说，我们如果可以使用三进制，
	 * 但是，电脑是二进制的，因此我们需要在二进制的基础上，利用多个bit来组合表示数字每个位的三种不同的状态。
	 * 
	 * 三种状态，我们知道我们需要两个bit来表示
	 * current(a,b)		increment(c)		next(a,b)
	 * 0,0				0					0,0
	 * 0,1				0					0,1
	 * 1,0				0					1,0
	 * 0,0				1					0,1
	 * 0,1				1					1,0
	 * 1,0				1					0,0
	 * 
	 * 根据真值表我们可以知道，如果一个数字重复三次，那么它会回到之前的状态。
	 * 现在，我们需要做的就是，利用数字电路的知识，得到其逻辑表达式。
	 * 
	 * 其实不难：对于a，把next中a=1对应的行组合选出来，对于每一个组合，
	 * 凡取值为1的变量写成原变量，取值为0的变量写成反变量，各变量相乘后得到一个乘积项；
	 * 最后，把各个组合对应的乘积项相加，就得到了相应的逻辑表达式。对于b同理
	 * 
	 * 由此我们可以得到
	 * a= a&~b&~c | ~a&b&c
	 * b= ~a&b&~c | ~a&~b&c
	 * 
	 * 在最后的结果上，我们将00->0, 01和10映射为1
	 * 最后的结果就是a|b
	 * 
	 * test1:1ms, beats 71.28%
	 * 最高票的那个答案应该就是将这个表达式化简了，而且节省了部分运算。
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0,c, ta;
        for(int i = 0;i < n;++i) {
        	c = nums[i];
        	ta = a;
        	a = (a&~b&~c) | (~a&b&c);
        	b = (~ta&b&~c) | (~ta&~b&c);
        }
        return a|b;
    }
}
