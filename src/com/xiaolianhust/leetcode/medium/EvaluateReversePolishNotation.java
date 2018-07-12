package com.xiaolianhust.leetcode.medium;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
	/**
	 * �����ӷ���
	 * ���ø�ϰ��������ݽṹ���㷨�������Ͼ����ջ��Ӧ�á�
	 * 
	 * test1: 5ms, beats 99.49% ��=��=��=��(�b��b;)��
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<>();
		final String ops = "+-*/";
		for(String curr : tokens) {
			if(ops.contains(curr)) {
				int num1, num2, result = 0;
				num2 = stack.removeLast();
				num1 = stack.removeLast();
				char op = curr.charAt(0);
				switch(op) {
				case '+':result = num1 + num2;break;
				case '-':result = num1 - num2;break;
				case '*':result = num1 * num2;break;
				case '/':result = num1 / num2;break;
				}
				stack.addLast(result);
			}
			else 
				stack.addLast(Integer.valueOf(curr));
		}
		return stack.removeLast();
    }
}
