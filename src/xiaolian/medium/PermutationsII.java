package xiaolian.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PermutationsII().permuteUnique(new int[] {1,2,1,2}));
	}
	/**
	 * 思路：
	 * 跟前面拿到{@link Permutation}差不多的思路，但是遇到重复掠过
	 * 
	 * 不行，这个思路非常不好解决重复性的问题。
	 * 明天再来撸。
	 * 
	 * discuss:
	 * 它的idea是，由于数字总量是一定的，相同的数字如果放在同一位置上就毫无意义，直接忽略，然后遍历对该索引
	 * 位置而言所有可能不同的情况。
	 * 厉害！学习了，让我从一个全新的角度认识了排列组合。
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
}
