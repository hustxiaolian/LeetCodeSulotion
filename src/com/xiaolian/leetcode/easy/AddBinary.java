package com.xiaolian.leetcode.easy;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary2("11", "1"));
	}
	
	/**
	 * ��һ��˼·��
	 * �͸�����ƽʱ��ֽ�ϼ���һ��
	 * 
	 * test1:7ms,beats 24.11%��=��=��=��(�b��b;)��
	 * ԭ��ÿ����sb���ײ����룬�϶�����
	 * 
	 * ʹ��char�������洢�м����������ת��Ϊstring
	 * @param a
	 * @param b
	 * @return
	 */
    public static String addBinary(String a, String b) {
        int na = a.length();
        int nb = b.length();
        int n = Math.min(na, nb);
        int flag = 0;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for(;i < n;++i) {
        	int temp = a.charAt(na - 1 - i) + b.charAt(nb - 1 - i) - '0' - '0' + flag;
        	flag = temp / 2;
        	sb.insert(0, temp % 2);
        }
        
        for(;i < na; ++i) {
        	int temp = a.charAt(na - 1 - i) - '0' + flag;
        	flag = temp / 2;
        	sb.insert(0, temp % 2);
        }
        
        for(;i < nb; ++i) {
        	int temp = b.charAt(nb - 1 - i) - '0' + flag;
        	flag = temp / 2;
        	sb.insert(0, temp % 2);
        }
        
        if(flag != 0)
        	sb.insert(0, 1);
        return sb.toString();
    }
    
    public static String addBinary2(String a, String b) {
    	int na = a.length();
        int nb = b.length();
        int nmin = Math.min(na, nb);
        int nmax = Math.max(na, nb);
        int flag = 0;
        char[] resultArr = new char[nmax + 1];
        int i = 0;
        for(;i < nmin;++i) {
        	int temp = a.charAt(na - 1 - i) + b.charAt(nb - 1 - i) - '0' - '0' + flag;
        	flag = temp / 2;
        	resultArr[nmax - i] = (char) (temp % 2 + '0');
        }
        
        for(;i < na; ++i) {
        	int temp = a.charAt(na - 1 - i) - '0' + flag;
        	flag = temp / 2;
        	resultArr[nmax - i] = (char) (temp % 2 + '0');
        }
        
        for(;i < nb; ++i) {
        	int temp = b.charAt(nb - 1 - i) - '0' + flag;
        	flag = temp / 2;
        	resultArr[nmax - i] = (char) (temp % 2 + '0');
        }
        if(flag != 0) {
        	resultArr[0] = '1';
        	return String.valueOf(resultArr);
        }
        else 
        	return String.valueOf(resultArr).substring(1);
        
        
    }

}
