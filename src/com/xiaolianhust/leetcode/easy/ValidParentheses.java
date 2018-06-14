package com.xiaolianhust.leetcode.easy;


import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author 25040
 *
 *
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
 */
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid3("()");

	}
	static char[] symbols = new char[] {'{','[', '(', ')', ']', '}'};
	static HashMap<Character, Integer> map = new HashMap<>();
	static {
		for(int i = 0;i < 6;++i)
        	map.put(symbols[i], i);
	}
	
	/**
	 * ˼·��
	 * ��һ�ۿ���ȥ�����ƾ���Ҫ��ջ��ʵ����������
	 * ���岽���ǣ������ַ�����ÿ���ַ����ж����ң��������ֱ����ӵ�ջ����������ң��ж�ջ��Ԫ���Ƿ��Ƕ�Ӧ������š�
	 * �ַ�����ɺ��ж�ջ���Ƿ���Ԫ�أ�����false���������true
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for(int i = 0; i < n; ++i) {
			char ch = s.charAt(i);
			Integer result = map.get(ch);
			if(result != null) {
				if(result < 3) 
					stack.push(ch);
				else {
					if(stack.isEmpty() || stack.pop() != symbols[5 - result])
						return false;
				}
			}
		}
		
		if(!stack.isEmpty())
			return false;
        
		return true;
    }
	
	/**
	 * ���˼·����������������
	 * �ҷ���������ƴ���ܵĻ��ϣ�Խ�ӽ�c�ı��뷽ʽ�������ٶ�Խ��
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for(int i = 0; i < n;++i) {
			char ch = s.charAt(i);
			
			if(ch == '(' || ch == '[' || ch == '{') 
				stack.push(ch);
			else if(ch == ')' || ch == ']' || ch == '}'){
				if(stack.isEmpty())
					return false;
				char temp = stack.pop();
				switch(ch) {
				case ')' : 
					if(temp != '(') return false;break;
				case ']':
					if(temp != '[') return false;break;
				case '}':
					if(temp != '{') return false;break;
				}
			}
		}
		
		if(!stack.isEmpty())
			return false;
        
		return true;
    }
	
	/**
	 * ���˼·����������������
	 * �ҷ���������ƴ���ܵĻ��ϣ�Խ�ӽ�c�ı��뷽ʽ�������ٶ�Խ��
	 * 
	 * ����ʱ�䣺9ms, beats 93.29%
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid3(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		
		for(int i = 0; i < n;++i) {
			char ch = s.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') 
				stack.push(ch);
			else if(ch == ')' && (stack.isEmpty() || stack.pop() != '(')) 
				return false;
			else if(ch == ']' && (stack.isEmpty() || stack.pop() != '[')) 
				return false;
			else if(ch == '}' && (stack.isEmpty() || stack.pop() != '{')) 
				return false;
		}
		
		if(!stack.isEmpty())
			return false;
        
		return true;
    }
}
