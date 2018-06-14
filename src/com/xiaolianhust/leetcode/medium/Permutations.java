package com.xiaolianhust.leetcode.medium;

import java.util.*;

/**
 * 
 * @author 25040
 * 
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[] {0,1}));
	}
	
	/**
	 * 思路其实已经很清晰了：
	 * 就是用我之前想的——空位插入法。
	 * 
	 * test1:7ms, beats 64.55%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * 其他人怎么都是用递归做的，就我的思路最为清奇
	 * 
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        
        if(n != 0) {
        	result.add(new ArrayList<>(Arrays.asList(nums[0])));
        	for(int i = 1;i < n;++i) {
        		int cnt = result.size();
        		while(cnt-- != 0) {
        			List<Integer> old = result.removeFirst();
        			int k = old.size();
        			for(int j = 0;j <= k;++j) {
        				ArrayList<Integer> oneAns = new ArrayList<>(old);
        				oneAns.add(j, nums[i]);
        				result.addLast(oneAns);
        			}
        		}
        	}
        }
        
        return result;
    }

}
