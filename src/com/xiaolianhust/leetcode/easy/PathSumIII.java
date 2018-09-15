package com.xiaolianhust.leetcode.easy;

import java.util.HashMap;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class PathSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * �ҵô���˼·û�����Ǵ���û���뵽���е�currSum-target = prefix sum�����ʽ�ϣ�
	 * �ɴˣ�����ÿ�ֶ�������ȫ����һ��map�����ǲ��ɽ��ܵġ�
	 * ����������˼·��û���������⡣
	 * 
	 * ����discuss���ܽ����£�
	 * 1. ʹ��һ��map���洢��keyΪprefix sum,valueΪ�м���·�����Եõ����prefix sum
	 * 2. ʹ��һ��currSum���洢Ŀǰ�Ӷ����µ�·���ͣ���ôcurrSum - target�����prefix sum, ��ô˵���н�ѡ·��
	 * 
	 * 
	 * ѧϰ�ˣ�лл��
	 * @param root
	 * @param sum
	 * @return
	 */
	private int result = 0;
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return result;
    }
	/**
	 * 
	 * @param t
	 * @param sum
	 * @param i
	 * @param map
	 */
	private void helper(TreeNode t, int target, int currAllSum, HashMap<Integer, Integer> map) {
		//��׼����
		if(t == null)
			return;
		//����ǰ�ڵ���뵽��sum��
		currAllSum += t.val;
		//�жϵ�ǰ�ڵ㼰�����ϣ���û�з���������·��
		if(map.containsKey(currAllSum - target))
			result += map.get(currAllSum - target);
		
		//����ǰcurrAllSum����map
		if(!map.containsKey(currAllSum))
			map.put(currAllSum, 1);
		else
			map.put(currAllSum, map.get(currAllSum) + 1);
		
		//�����������ӽڵ�ݹ�
		helper(t.left, target, currAllSum, map);
		helper(t.right, target, currAllSum, map);
		map.put(currAllSum, map.get(currAllSum) - 1);
	}
}
