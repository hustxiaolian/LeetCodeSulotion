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
	 * 思路：
	 * 第一眼看过去，估计就是要用栈来实现先入后出。
	 * 具体步骤是：遍历字符串的每个字符，判断左右，如果是左，直接添加到栈顶，如果是右，判断栈顶元素是否是对应的左符号。
	 * 字符串完成后，判断栈中是否还有元素，有则false，否则就是true
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
	 * 这个思路纯粹的用数组操作。
	 * 我发现在这种拼性能的活上，越接近c的编码方式，往往速度越快
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
	 * 这个思路纯粹的用数组操作。
	 * 我发现在这种拼性能的活上，越接近c的编码方式，往往速度越快
	 * 
	 * 运行时间：9ms, beats 93.29%
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
