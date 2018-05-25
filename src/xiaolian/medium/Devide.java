package xiaolian.medium;

public class Devide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide2(7, -3));
	}
	
	/**
	 * ��һ��˼·��
	 * ���ü��ţ����ļ�һ���Ĵ������϶��ܽ������һ�����������ʱint.max / 1����Ҫ����int.max����������ʵ��̫����
	 * test1:��ʱ�ˡ�
	 * 
	 * �ڶ���˼·��
	 * �Ⱦ����Ÿ���Ŀ�����䣬Ȼ�����������С�Ŀ顣
	 * ʱ����ޣ�������30�Σ�һ�������������
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
        	//ͬ�ŵ����
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
        	//��ͬ�ŵ������
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
	 * �ڶ���˼·��
	 * �Ⱦ����Ÿ���Ŀ�����䣬Ȼ�����������С�Ŀ顣
	 * ʱ����ޣ�������30�Σ�һ�������������
	 * 
	 * test2:46ms, beats 53.71%(��=��=��=��(�b��b;)��)
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
	 * ˼·��
	 * ��1��ʼ��ÿ�ζ�������ֱ����ֵ����dividend,���ظ�ֵ
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
