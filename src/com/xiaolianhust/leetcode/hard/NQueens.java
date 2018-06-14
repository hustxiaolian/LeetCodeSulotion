package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(1));
	}
	
	/**
	 * ��һ��˼·��
	 * ����ǰ����Ϥ��for+�ݹ��˼·.
	 * 
	 * test1:4ms, beats 99.84%��=��=��=��(�b��b;)��
	 * �ȱ��˸����ԭ��������������Ѿ������˽�������ɽ���ģ�
	 * ����ʹ����char���飬�����˷������ɲ���Ҫ�ַ�����ϵͳ������
	 * ����һЩϸ���ϵ��Ż��ɡ�
	 * 
	 * ��֮����εı���������Һ�����ġ�
	 * 
	 * @param n
	 * @return
	 */
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] columns = new int[n];
        search(0, n, result, columns);
        return result;
    }
	
	/**
	 * �����˼·��
	 * ��׼�����curr = n���ݹ鵽�˾�ͷ���������˽����oneAns�������У���������;�ͷ����ˣ�û�н��
	 * @param curr
	 * @param n
	 * @param result
	 * @param forbid
	 * @param oneAns
	 */
	private static void search(int curr, int n, List<List<String>> result, int[] columns) {
		if(curr == n) {
			List<String> oneAns = new ArrayList<>();
			char[] buf = new char[n];
			Arrays.fill(buf, '.');
			for(int i = 0;i < n;++i) {
				buf[columns[i]] = 'Q';
				oneAns.add(String.valueOf(buf));
				buf[columns[i]] = '.';
			}
			result.add(oneAns);
			return;
		}
		//����ǰ���Ѿ����ڵĻʺ󣬼��㵱ǰ�ݹ����У����ܷ��ûʺ��λ�á�
		int[] forbid = new int[n];
		for(int i = 0;i < curr;++i) {
			int temp = columns[i];
			//�еĴ����ɵݹ�������ơ��еĴ���
			forbid[temp] = 1;
			//б��Ĵ�
			if(temp + (curr - i) < n)
				forbid[temp + (curr - i)] = 1;
			if(temp - (curr - i) >= 0)
				forbid[temp - (curr - i)] = 1;
		}
		//����forbid����Ľ�����ݹ������һ���
		for(int i = 0;i < n;++i) {
			if(forbid[i] == 0) {
				columns[curr] = i;
				search(curr + 1, n, result, columns);
			}
		}
	}

}
