package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ������Ҽǵ������������ǲ��������֮ǰҪ�����˳��ӵ����ϣ����Ҫ��������¡�
	 * 
	 * test1:2ms, beast 86.14%��=��=��=��(�b��b;)��;
	 * һ��ͨ����û�������л�Լ���
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int cnt = 1;
        while(cnt != 0) {
        	int nextCnt = 0;
        	List<Integer> oneAns = new ArrayList<>();
        	for(int i = 0;i < cnt;++i) {
        		TreeNode currNode = queue.removeFirst();
        		oneAns.add(currNode.val);
        		if(currNode.left != null) {
        			++nextCnt;
        			queue.addLast(currNode.left);
        		}
        		if(currNode.right != null) {
        			++nextCnt;
        			queue.addLast(currNode.right);
        		}
        	}
        	result.add(oneAns);
        	cnt = nextCnt;
        }
        return result;
    }

}
