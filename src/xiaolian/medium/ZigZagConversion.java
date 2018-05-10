package xiaolian.medium;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 2));
		/*
		if(new ZigZagConversion().convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI")) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		*/
	}
	
	/**
	 * ˼·��
	 * �򵥴ֱ������ԣ���ͼ��⣬���ǿ��Դ�֮���ε������Ϸ���һЩ��ѧ���ɡ�
	 * ���ǿ��Լ򵥵��Ƶ���������ѧ��ʽ����n
	 * 1. ��һ��ͼ�ε���������Ϊ0,2*(n-1),4(n-1)...
	 * 2. ���һ����������Ϊn-1,3*(n-1),5(n-1)...
	 * 3. �м��ŵ�������������Ǳ仯�ģ�2*(n-1 -i),2*i������������������iΪ��ǰ����
	 * 
	 * test1:110ms
	 * test2:ʹ��stringbuffer�࣬���Ƶ����string����ӣ������޴�54ms
	 * 
	 * ����Ľ���ֻ�ܰ������������д���������c���ԡ�
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		int slength = s.length();
		int interval = numRows - 1;
		if(interval == 0 || slength == 0 || slength <= numRows)  return s;//�����������
		StringBuffer sb = new StringBuffer();
		int tempInterval;
		int i,j,row;
		
		//�ѵ�һ�ŷ���
		for(i = 0;i < slength; i += 2 * interval) {
			sb.append(s.charAt(i));
		}
		//�м��ţ��������м������һ������ͳһ����
		for(row = 1; row < numRows - 1; ++row) {
			for(i = 0, j = row;j < slength;j += tempInterval) {
				sb.append(s.charAt(j));
				tempInterval = 2 * (i++ % 2 == 0? (interval  - row): row); 
			}
		}
		//���һ��
		for(i = interval;i < slength; i += 2 * interval) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
    }
}
