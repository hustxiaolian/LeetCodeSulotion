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
