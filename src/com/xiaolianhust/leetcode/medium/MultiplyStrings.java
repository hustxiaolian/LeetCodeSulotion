package com.xiaolianhust.leetcode.medium;



/**
 * 
 * @author 25040
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.


 */
public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("123", "456"));
	}
	/**
	 * 思路：
	 * 先将所有的字符映射到一个数组上，然后对数组进行操作。
	 * 用数组操作，模拟进位的过程。
	 * 
	 * 具体步骤：
	 * 核心思路就是我们平常计算乘法的那样，只是变成了在数组上操作。
	 * 
	 * test1:29ms, beats 75.76%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public static String multiply(String num1, String num2) {
    	//确保num1的长度比较短
        if(num1.length() > num2.length()) {
        	String temp = num1;
        	num1 = num2;
        	num2 = temp;
        }
        //初始化变量，处理特殊情况
    	int length1 = num1.length();
        int length2 = num2.length();
        if(length1 == 1 && num1.charAt(0) == '0') return "0";
        
        //初始化一个足够大的数组，用于储存结果。
        int[] resArr = new int[length1 + length2];
        int reslength = resArr.length;
        int i = 0, j = 0, flag = 0;
        
        //遍历num1的每个字符，然后让resArr像我们手动做乘法运算那样，计算结果
        for(i = 0;i < length1;++i) {
        	int currNum = num1.charAt(length1 - 1 - i) - '0';
        	int k = length2 - 1;
        	flag = 0;
        	for(j = reslength - 1 - i;k >= 0;--j, --k) {
        		int mul = (num2.charAt(k) - '0') * currNum + flag + resArr[j];
        		resArr[j] = mul % 10;
        		flag = mul / 10;
        	}
        	if(flag != 0)
        		resArr[j] = flag;
        }
        if(resArr[j] == 0)
        	++j;
        StringBuffer sb = new StringBuffer();
        for(;j < reslength;++j) {
        	sb.append(resArr[j]);
        }
        return sb.toString();
    }
}
