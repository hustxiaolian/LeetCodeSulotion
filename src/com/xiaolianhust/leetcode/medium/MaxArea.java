package com.xiaolianhust.leetcode.medium;

public class MaxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ˼·����������һ��˭�����뵽�ķ���������ѭ����⡣
	 * 
	 * �����time out!��Ȼ���ֻ�ɫ��
	 * �ұ��������ο�������к����������㷨���ҵ����ֵ�ͱ���ɨ����ÿ��С��ֱ�ӵù�ϵ����������������㷨��
	 * ���ǣ����ܾ��ô���������ɨ���ȥ��Ҳ�������������㷨��Ӧ���Ǵ��ڵá��������롣
	 * ���˰�Сʱ��û�а��˼·��ͷ�������˹ٷ�solution������һ���֣�������֣�����
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
        int n = height.length;
        int result = 0;
		for(int i = 0;i < n;++i) {
			for(int j = i;j < n;++j) {
				if(Math.min(height[i], height[j]) * (j - i) > result) {
					result = Math.min(height[i], height[j]) * (j - i);
				}
			}
		}
		
		return result;
    }
	
	/**
	 * �����˼����ǣ�
	 * ��� = x * min_y����ô��������x���Ȼ�����������м��ƶ���
	 * ��ͼ��⣬����Ҵ��������˿�ʼ�������ж�����ָ���Ӧ�Ĵ�С�����ǰ�����ֵ��С��ָ�����м��ƶ���
	 * Ϊ������Ҫ��ô������Ϊ��������ƶ������Ǳߣ����ڶ̱����ƣ���ô����ֻ�Ǽ�С��x����min_y����û�������û��Ҫ�ж��ˡ�
	 * �������㷨ʡ���������ⲿ��û��������㡣���Բ��ܴﵽ���ԡ�
	 * 
	 * �����8ms,���95%��
	 * ����������������ԭ��ʹ�þֲ��������ٲ���Ҫ���ڴ���á�
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		int n = height.length;
		int result = 0;
		int sline, eline;//���ٻ���ԭ��
		
		for(int s = 0, e = n - 1;s < e;) {
			sline = height[s];
			eline = height[e];
			if(sline > eline) {
				result = Math.max(result, eline * (e - s));
				--e;
			}
			else {
				result = Math.max(result, sline * (e - s));
				++s;
			}
		}
		
		return result;
	}

}
