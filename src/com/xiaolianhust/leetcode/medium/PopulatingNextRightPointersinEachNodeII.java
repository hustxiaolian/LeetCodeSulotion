package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.PopulatingNextRightPointersinEachNode.*;

public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ˼·���������Ŀ������һģһ���ģ�ֻ������β��������Ķ�������
	 * ����������ø��Ӷ�����
	 * 
	 * �̳����������˼·��
	 * ѧϰ����ĵ�����˼·��һ��һ��ĵݹ����¡����ǽ�����ѵ�������ô�ж���ô������
	 * ��������ۣ�
	 * �仯��������Ҫ�ǣ���ǰ�ڵ��������ҽڵ㣬��ǰ������next�ڵ㣬next�ڵ������ӽڵ㡣
	 * 
	 * test1:2ms, 55.41%��=��=��=��(�b��b;)��
	 * ���иĽ��ռ䡣��������ɿ��Ա���һ����һ�����ӵ�child��㣬�������ⷴ����next�����������������һ�����ظ���
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		TreeLinkNode currLevelStart = root;
		while(currLevelStart != null) {
			TreeLinkNode levelp = currLevelStart;
			TreeLinkNode nextLevelStart = null;
			while(levelp != null) {
				if(nextLevelStart == null && (levelp.left != null || levelp.right != null)) {
					nextLevelStart = levelp.left != null ? levelp.left : levelp.right;
				}
				if(levelp.left != null) {
					if(levelp.right != null)
						levelp.left.next = levelp.right;
					else
						connectWithNext(levelp.left, levelp.next);
				}
				if(levelp.right != null) {
					connectWithNext(levelp.right, levelp.next);
				}
				levelp = levelp.next;
			}
			currLevelStart = nextLevelStart;
		}
    }
	
	/**
	 * 
	 * @param left
	 * @param next
	 */
	private void connectWithNext(TreeLinkNode levelpChild, TreeLinkNode next) {
		levelpChild.next = null;
		while(next != null) {
			if(next.left != null) {
				levelpChild.next = next.left;
				break;
			}
			if(next.right != null) {
				levelpChild.next = next.right;
				break;
			}
			next = next.next;
		}
	}
	
	/**
	 * ��һ��lastChild�ڵ���������һ�����ӵ�child.
	 * �����ͷ�ڵ㣬��������һ��Ѱ����ʼ�Ķ���Ķ�����жϡ�
	 * ����currChild�ڵ�����ظ����������Կ�Խ������ڵ�����
	 * 
	 * test1:1ms, beats 100.0%��=��=��=��(�b��b;)��
	 * �������ǰ������е���·Ҳ�ù���������Ϊ��ѧϰ�ˡ�
	 * @param root
	 */
	public void connect2(TreeLinkNode root) {
		TreeLinkNode currLevel = root;
		while(currLevel != null) {
			TreeLinkNode header = new TreeLinkNode(0);
			TreeLinkNode currChild = header;
			while(currLevel != null) {
				if(currLevel.left != null) {
					currChild.next = currLevel.left;
					currChild = currChild.next;
				}
				if(currLevel.right != null) {
					currChild.next = currLevel.right;
					currChild = currChild.next;
				}
				currLevel = currLevel.next;
			}
			currLevel = header.next;
		}
	}

}
