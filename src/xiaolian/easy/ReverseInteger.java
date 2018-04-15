package xiaolian.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-123));
	}
	
	/**
	 * 第一个思路：
	 * 1.先把x转成字符串，然后对字符串进行处理。
	 * 
	 * 细化思路和细节：
	 * 1.判断是否是负数，使用局部变量保存
	 * 2.abs（x）转换为字符串，然后遍历字符串的每个字符，交换它们的位置
	 * 3.把转换完成的字符串转换为int（注意这里有溢出的问题）
	 * 4.判断溢出，并且加上可能的符号
	 * 
	 * 问题：怎么判断这个数的reverse是否溢出了。
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse1(int x) {
		//提取符号
		int result = Math.abs(x);
		int signal = x < 0 ? -1 : 1;
		
		//转换为字符串数组
		String s = Integer.toString(result);
		s = new StringBuffer(s).reverse().toString();
		
		
		
		result = Integer.valueOf(s);
		//暂时不考虑溢出,果然对于比较大的数据有溢出风险。
		
		return result * signal;
	}
	
	/**
	 * 
	 * 上面的思路非常不利于处理诸如Tmin这样蛋疼的数字，以及如何判断是否溢出的问题。
	 * 这里借鉴和参考了leetcode上的第一个大佬的答案。谢谢。
	 * 
	 * 其基本思路和想法：
	 * 使用%，*10 /10这样基本的算法运行来达到将数字倒过来的目的。
	 * 其溢出判断条件是：
	 * 如果将迭代计算的过程中发生了符号突变，也就是原本x为正数，当计算迭代的某个轮次时，突然变成了负数，反之依然。
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int result = 0;
		int signal = x < 0 ? -1 : 1;
		int tailBitNum;
		int lastResult = 0;
		
		while(x != 0) {
			//提取当前迭代的末尾数字
			tailBitNum = x % 10;
			//然后使用honor算法来重新拼接数字
			result = result * 10 + tailBitNum;
			//这里判断一下是否溢出，让我们想一下计算过程中如果int溢出，他会发生符号突变
			//bug 1 当负数末尾数字刚好是0时，出错。比如-10.所以需要排除掉result=0这种情况-100000
			//bug 2 看来有时候不能使用符号突变原理来判断，可能这个java有其不同于c语言的性质.这里再反向计算验证一遍
			if(((result - tailBitNum) / 10) != lastResult){
				return 0;
			}
			//进入下一轮迭代
			x /= 10;
			lastResult = result;
		}
		
		return result;
	}

}
