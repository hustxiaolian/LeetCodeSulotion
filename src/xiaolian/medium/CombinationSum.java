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
	 * ˼·�����ȱ���ÿ���ַ���Ȼ�󽫣�û���һ���ַ�����target��ȥ��ǰ�ַ���������֤ȥ���ظ���
	 * Ȼ��ȥǰ����ʵ��Ӽ���Ѱ�Һ��ʵĴ𰸡�
	 * 
	 * Ѱ���Ӽ��𰸵ķ�ʽ�������Ҹо�����һ�ֵݹ���߼�������ĵ��� ǰ��� + ��ǰ�ַ���
	 * ���������¡�
	 * 
	 * test1:18ms, beats 86.97%(��=��=��=��(�b��b;)��)
	 * ����⵹��һ��ͦ����ݹ����Ŀ�����ҿ����Ż��ĵط��ǳ��ࡣ
	 * ����˵��ô���ó���ȥ���ٵݹ���̡�
	 * 
	 * test2:18ms, ��discuss��͵ʦ��ѧϰ������ø��Ӽ�����ŵĵݹ��㷨��
	 * test3:15ms, ѧϰ�ˣ��Ժ���ʹ��ArrayList�������ٶ���ȷʵ����Ҫ��һЩ����=��=��=��(�b��b;)��
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum12(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> cache = new ArrayList<>();
		int n = candidates.length;
		Arrays.sort(candidates);	
		searchSum3(candidates, 0, target, cache, result, n);
		return result;
	}
	
	/*
    private static void searchSum2(int[] candidates, int curr, int target, LinkedList<Integer> cache,
			List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<>(cache));
			return;
		}
		if(target < 0)	return;
		for(int i = curr;i >= 0; --i) {
			cache.addLast(candidates[i]);
			searchSum2(candidates, i, target - candidates[i], cache, result);
			cache.removeLast();
		}
	}
    */
    private static void searchSum3(int[] candidates, int curr, int target, ArrayList<Integer> cache,
			List<List<Integer>> result, int n) {
		if(target == 0) {
			result.add(new ArrayList<>(cache));
			return;
		}
		if(target < 0)	return;
		for(int i = curr;i < candidates.length; ++i) {
			if(target < candidates[i]) break;
			cache.add(candidates[i]);
			searchSum3(candidates, i, target - candidates[i], cache, result, n);
			cache.remove(cache.size() - 1);
		}
	}
    

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> cache = new LinkedList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        int min = candidates[0];
        
        for(int i = 0; i < n;++i) {
        	int tempSum = target - candidates[i];
        	//ֻ��һ�����־��У���ôǰ��Ҳ���ǲ���Ҫ����
        	if(tempSum == 0) {
        		List<Integer> oneAns = new ArrayList<>();
        		oneAns.add(candidates[i]);
        		result.add(oneAns);
        	}
        	//�����ǰ����target��ǰ��������æ��Ϊ�˱����ظ����뱣֤��ǰ������һ������̬�滮˼��
        	else if(tempSum > 0) {
        		cache.add(candidates[i]);
        		if(tempSum > min) {
                	searchSum(candidates, i, tempSum, cache, result);
        		}
        		//���������㹻�ˣ�����һ���Ż��ɡ�
        		else if(tempSum == min) {
        			cache.add(min);
            		result.add(new ArrayList<>(cache));
        		}
        		//��������С����Сֵ���ǾͲ������У����÷����ˡ�
        		cache.clear();
        	}
        	else {
        		//���С��0��˵����������鶼����target���������ˣ�ֱ���˳���
        		break;
        	}
        }
        
        return result;
    }
    
    /**
     * ˼·��
     * ��left��right�ķ�Χ�ڣ�Ѱ�Ҵ𰸡��ݹ顣�����˼·�е㲻������
     * ����Ϊ������ǰ�Ĵ�ĩβ��ʼ���μ������Լ���������0��˵���Ⳣ�Բ����У�������һ����
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
    		if(newTarget > 0) {//��������ȥ
    			cache.addFirst(nums[i]);
    			searchSum(nums, i, newTarget, cache, result);
    		}
    		else if(newTarget == 0) {//�ҵ���
    			cache.addFirst(nums[i]);
    			result.add(new ArrayList<>(cache));
    		}
    		else {//̫С�ˡ�û���ҵ�,������һ����С������
    			continue;
    		}
    		cache.removeFirst();
    	}
    }

}
