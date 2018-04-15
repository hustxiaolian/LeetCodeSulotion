package xiaolian.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-123));
	}
	
	/**
	 * ��һ��˼·��
	 * 1.�Ȱ�xת���ַ�����Ȼ����ַ������д���
	 * 
	 * ϸ��˼·��ϸ�ڣ�
	 * 1.�ж��Ƿ��Ǹ�����ʹ�þֲ���������
	 * 2.abs��x��ת��Ϊ�ַ�����Ȼ������ַ�����ÿ���ַ����������ǵ�λ��
	 * 3.��ת����ɵ��ַ���ת��Ϊint��ע����������������⣩
	 * 4.�ж���������Ҽ��Ͽ��ܵķ���
	 * 
	 * ���⣺��ô�ж��������reverse�Ƿ�����ˡ�
	 * 
	 * @param x
	 * @return
	 */
	public static int reverse1(int x) {
		//��ȡ����
		int result = Math.abs(x);
		int signal = x < 0 ? -1 : 1;
		
		//ת��Ϊ�ַ�������
		String s = Integer.toString(result);
		s = new StringBuffer(s).reverse().toString();
		
		
		
		result = Integer.valueOf(s);
		//��ʱ���������,��Ȼ���ڱȽϴ��������������ա�
		
		return result * signal;
	}
	
	/**
	 * 
	 * �����˼·�ǳ������ڴ�������Tmin�������۵����֣��Լ�����ж��Ƿ���������⡣
	 * �������Ͳο���leetcode�ϵĵ�һ�����еĴ𰸡�лл��
	 * 
	 * �����˼·���뷨��
	 * ʹ��%��*10 /10�����������㷨�������ﵽ�����ֵ�������Ŀ�ġ�
	 * ������ж������ǣ�
	 * �������������Ĺ����з����˷���ͻ�䣬Ҳ����ԭ��xΪ�����������������ĳ���ִ�ʱ��ͻȻ����˸�������֮��Ȼ��
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
			//��ȡ��ǰ������ĩβ����
			tailBitNum = x % 10;
			//Ȼ��ʹ��honor�㷨������ƴ������
			result = result * 10 + tailBitNum;
			//�����ж�һ���Ƿ��������������һ�¼�����������int��������ᷢ������ͻ��
			//bug 1 ������ĩβ���ָպ���0ʱ����������-10.������Ҫ�ų���result=0�������-100000
			//bug 2 ������ʱ����ʹ�÷���ͻ��ԭ�����жϣ��������java���䲻ͬ��c���Ե�����.�����ٷ��������֤һ��
			if(((result - tailBitNum) / 10) != lastResult){
				return 0;
			}
			//������һ�ֵ���
			x /= 10;
			lastResult = result;
		}
		
		return result;
	}

}
