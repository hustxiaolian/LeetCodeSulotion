package xiaolian.medium;

public class Devide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide2(7, -3));
	}
	
	/**
	 * 第一种思路：
	 * 利用减号，疯狂的剪一定的次数，肯定能解出来。一个字慢，如果时int.max / 1岂不是要计算int.max次数。这样实在太慢了
	 * test1:超时了。
	 * 
	 * 第二种思路：
	 * 先尽量放更大的块来填充，然后依次填入更小的块。
	 * 时间界限：最多计算30次，一定可以算出来。
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide1(int dividend, int divisor) {
        int result, sign;
        sign = 1;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        	sign = -1;
        
        if(dividend == 0) return 0;
        
        int sum = divisor;
        result = 0;
        if(sign == 1) {
        	//同号的情况
        	if(dividend > 0) {
        		while(sum < dividend) {
        			sum += divisor;
        			++result;
        		}
        	}
        	else {
        		while(sum > dividend) {
        			sum += divisor;
        			++result;
        		}
        	}
        }
        else {
        	//不同号的情况下
        	if(dividend > 0) {
        		sum = -divisor;
        		while(sum < dividend) {
        			sum += (-divisor);
        			--result;
        		}
        	}
        	else {
        		dividend = -dividend;
        		while(sum < dividend) {
        			sum += divisor;
        			--result;
        		}
        	}
        }
        
        return result;
    }
	
	/**
	 * 第二种思路：
	 * 先尽量放更大的块来填充，然后依次填入更小的块。
	 * 时间界限：最多计算30次，一定可以算出来。
	 * 
	 * test2:46ms, beats 53.71%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide2(int dividend, int divisor) {
		int result, sign;
		long lresult;
		long ldividend, ldivisor;
        sign = 1;
        
        if(dividend == 0) return 0;
        if(divisor == 1)
        	return dividend;
        if(divisor == -1) 
        	if(dividend == Integer.MIN_VALUE)
        		return Integer.MAX_VALUE;
        	else
        		return -dividend;
        
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        	sign = -1;
        
        ldividend = Math.abs((long)dividend);
        ldivisor = Math.abs((long)divisor);
        
        lresult = overHalfVal(ldividend, ldivisor);
        
        if(lresult > Integer.MAX_VALUE) {
        	result = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else {
        	result = (int)(sign * lresult);
        }
        return result;
	}
	
	/**
	 * 思路：
	 * 从1开始，每次都翻倍，直到该值超过dividend,返回该值
	 * @return
	 */
	private static long overHalfVal(long ldividend, long ldivisor) {
		if(ldividend < ldivisor)
			return 0;
		
		long sum = ldivisor;
		long result = 1;
		
		while(sum + sum <= ldividend) {
			result += result;
			sum += sum;
		}
			
		return result + overHalfVal(ldividend - sum, ldivisor);
	}

}
