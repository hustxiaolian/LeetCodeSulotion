package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new PermutationsII().permuteUnique(new int[] {1,2,1,2}));
		System.out.println(permuteUnique2(new int[] {1,1,2}));
	}
	/**
	 * ˼·��
	 * ��ǰ���õ�{@link Permutation}����˼·�����������ظ��ӹ�
	 * 
	 * ���У����˼·�ǳ����ý���ظ��Ե����⡣
	 * ��������ߣ��
	 * 
	 * discuss:
	 * ����idea�ǣ���������������һ���ģ���ͬ�������������ͬһλ���Ͼͺ������壬ֱ�Ӻ��ԣ�Ȼ������Ը�����
	 * λ�ö������п��ܲ�ͬ�������
	 * ������ѧϰ�ˣ����Ҵ�һ��ȫ�µĽǶ���ʶ��������ϡ�
	 * 
	 * �ٴλع���PermutationsII������������û����ͨ�����⣬����ٴ�ʹ���˲�ͬ�ķ���������
	 * �ϴ�����֪�����ظ�Ԫ�ص�ȫ���о�����취ȥ������ǰλ�����Ѿ����ּ�����˵�Ԫ�أ�֮ǰͨ��hashSet��ɣ�
	 * �����ͨ���������ͬ��Ԫ�ط���һ����ôÿ����Ҫ�жϵĶ�������ˣ����Ԫ���Ƿ��Ѿ����ù��ˣ�
	 * ��Σ����û���ù������Ƿ��Ѿ���֮ǰ��Ԫ����ͬ������ظ����㣬
	 * !used[i-1]��һ����жϾ���Ϊ�˱�֤�ǵ�ǰ�ִε��ظ�����ǰ��λ�õ��ظ��Ǻ������ġ�
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        permute(result, nums, 0);
        return result;
    }
	
	private void permute(List<List<Integer>> result, int[] nums, int index) {
		if(index == nums.length) {
			List<Integer> onsAns = new ArrayList<>();
			for(int num : nums)
				onsAns.add(num);
			result.add(onsAns);
			return;
		}
		
		HashSet<Integer> appeared = new HashSet<>();
		for(int i = index;i < nums.length; ++i) {
			if(appeared.add(nums[i])) {
				swap(nums, index, i);
				permute(result, nums, index + 1);
				swap(nums, index, i);
			}
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static List<List<Integer>> permuteUnique2(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		if(n == 0) return result;
		Arrays.sort(nums);
		List<Integer> cache = new ArrayList<>();
		boolean[] used = new boolean[n];
		helper(nums, result, cache, used, 0, n);
		return result;
	}
	
	/**
	 * 
	 * @param nums ���ݵ�����
	 * @param result ���
	 * @param cache ���壬��¼��ǰ���ɵ�ȫ���л��壬
	 * @param used ��¼��ǰ�����л�������Щ���֣���Ӧ��������Ϊtrue����Ϊ���ڵ�ǰ�ݹ�����˵��used[i] = true��������������֮ǰ�Ĳ���У�
	 * @param curr ȫ���еĵ�ǰλ��
	 * @param n ���鳤��
	 */
	private static void helper(int[] nums, List<List<Integer>> result, List<Integer> cache, boolean[] used, int curr, int n) {
		//��׼����,cache���Ѿ�������һ����������ȷ��ȫ�������
		if(curr == n) {
			List<Integer> oneAns = new ArrayList<>(cache);
			result.add(oneAns);
			return;
		}
		
		for(int i = 0;i < n;++i) {
			if(used[i]) continue;
			if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])//���ﱣ֤���㣬����ĸ���ӣ���ǰλ�ã���ͬ��ĸֻѡһ����Ϊ�˱�֤��ȷ�ԣ����ǰ���Ǹ������ù��ˣ���Ȼ���������ǻ��ǿ���
				continue;
			cache.add(nums[i]);
			used[i] = true;
			helper(nums, result, cache, used, curr + 1, n);
			used[i] = false;
			cache.remove(cache.size() - 1);
		}
	}
}
