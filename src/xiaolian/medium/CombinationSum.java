package xiaolian.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author 25040
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 */
public class CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] {8,7,4,3}, 11));
	}
	
	/**
	 * 思路：首先遍历每个字符，然后将，没添加一个字符，先target减去当前字符，这样把证去掉重复。
	 * 然后去前面合适的子集来寻找合适的答案。
	 * 
	 * 寻找子集答案的方式，等下我感觉这是一种递归的逻辑，后面的等于 前面的 + 当前字符。
	 * 必须排序下。
	 * 
	 * test1:18ms, beats 86.97%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * 这道题倒是一道挺不错递归的题目。而且可以优化的地方非常多。
	 * 比如说怎么利用除法去加速递归过程。
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> cache = new LinkedList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        int min = candidates[0];
        
        for(int i = 0; i < n;++i) {
        	int tempSum = target - candidates[i];
        	if(tempSum == 0) {
        		List<Integer> oneAns = new ArrayList<>();
        		oneAns.add(candidates[i]);
        		result.add(oneAns);
        	}
        	else if(tempSum > 0) {
        		cache.add(candidates[i]);
        		if(tempSum > min) {
                	searchSum(candidates, i, tempSum, cache, result);
        		}
        		else if(tempSum == min) {
        			cache.add(min);
            		result.add(new ArrayList<>(cache));
        		}
        		cache.clear();
        	}
        	else {
        		break;
        	}
        }
        
        return result;
    }
    
    /**
     * 思路：
     * 从left到right的范围内，寻找答案。递归。具体的思路有点不好描述
     * 大致为，当当前的从末尾开始依次减，尝试减，减到《0，说明这尝试不可行，尝试下一个。
     * @param nums
     * @param left
     * @param right
     * @param target
     * @param cache 
     * @param result
     */
    private static void searchSum(int[] nums, int right, int target, LinkedList<Integer> cache, List<List<Integer>> result) {
    	if(target < nums[0])
    		return;
    	for(int i = right; i >= 0; --i) {
    		int newTarget = target - nums[i];
    		if(newTarget > 0) {//继续找下去
    			cache.addFirst(nums[i]);
    			searchSum(nums, i, newTarget, cache, result);
    		}
    		else if(newTarget == 0) {//找到了
    			cache.addFirst(nums[i]);
    			result.add(new ArrayList<>(cache));
    		}
    		else {//太小了。没法找到。
    			continue;
    		}
    		cache.removeFirst();
    	}
    }

}
