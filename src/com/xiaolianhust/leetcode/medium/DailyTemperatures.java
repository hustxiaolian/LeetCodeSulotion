package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(dailyTemperatures2(new int[] {1,1,1,1,5,6,1,8})));
	}
	
	/**
	 * ˼·��
	 * �����˼��������ö�ջ�����½��ص���ֵ�ȴ洢�������ȴ����»�����
	 * 
	 * �ܽ�˼����
	 * stack��ջʵս��⣺��ջ��ʵ����һ�֣���ǰ���������ʱ���£�����ȥ���������飬��ͷ�����ɡ�
	 * ���ε������������� �ˣ������ʺ��������������ٳ�����
	 * 
	 * ����������ԣ�����˵�������ÿ����¶�ѹ����ջ���ȴ��¶ȳ����ҵ�ʱ��ͣ�¡�
	 * ���������������ô����ͱ�pop�ˣ�����⼸�춼û���¶ȱ��Ҵ���ô��һֱѹ�ڶ�ջ�еȵ����С�
	 * 
	 * ������Ĺ��ɿ��Կ�����stack�дӶ������Ǵ�С�����˳��
	 * 
	 * test1: 76ms, beats 30.82%��=��=��=��(�b��b;)��
	 * test2: 63ms, beats 52.71% ��=��=��=��(�b��b;)��
	 * �ҿ���ǰ�Ŵ�����ô���ġ���ô�졣ǰ�ŵĴ��ж���ʹ���Լ�������array��ջ��
	 * 
	 * 
	 * test3: 9ms, beats 93.36% ��=��=��=��(�b��b;)��
	 * ���գ���ô�졣�����Ժ��������������Ŀ��ʱ�򣬿���ʹ���Լ������������ջ������Ŀ졣
	 * ���˾��ã���Ҫ����һ��ʼ�ʹ������㹻��Ŀռ䣬��˲���������ʱ������Ҫ����ռ䣬�
	 * @param temperatures
	 * @return
	 */
	public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        stack.push(0);
        for(int i = 1;i < n;++i) {
        	while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        		int temp = stack.pop();
        		result[temp] = i - temp;
        	} 
        	stack.push(i);
        }
        //���ˣ���һ����ȫ����Ҫ����Ϊjava��ʼ��Ϊ0
        /*
        while(!stack.isEmpty()) {
        	result[stack.pop()] = 0;
        }
        */
        return result;
    }
	
	public static int[] dailyTemperatures2(int[] temperatures) {
		int n = temperatures.length;
		int[] result = new int[n];
		if(n < 2) return result;
		int[] stack = new int[n];
		int idx = -1;
		stack[++idx] = 0;
		
		for(int i = 1;i < n;++i) {
			int curr = temperatures[i];
			while(idx >= 0 && curr > temperatures[stack[idx]]) {
				int temp = stack[idx--];
				result[temp] = i - temp;
			}
			stack[++idx] = i;
		}
		return result;
	}
}
