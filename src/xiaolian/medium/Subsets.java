package xiaolian.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Subsets().subsets(new int[] {}));
	}
	
	/**
	 * 第一种思路：
	 * 卧槽，我才发现没写思路，这不太好。以后就算这道题很简单，也必须写思路再编码，养成良好的习惯。
	 * 核心idea：由于是求给定数字所有的子集合，那么这道题可以看成是求组合的变种，之前我们通过k来控制子集合中
	 * 元素的个数，现在直接在递归过程中，遍历添加所有的可能性。
	 * 
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int n = nums.length;
        if(n == 0) return result;
        int[] cache = new int[n];
        searchSub(result, nums, n, cache, 0, 0);
        return result;
    }
    
    /**
     * 每轮的递归相当于对于每个集合中当前索引位置上的各种可能性。
     * 注意到，这里没有标准递归形式的基准情况，隐含的基准情况就是
     * startindex >= n 就return。
     * 
     * {@link Combination}
     * @param result 最终结果list
     * @param nums 输入数组
     * @param n 表示数组长度，控制遍历边界
     * @param cache 结果缓存数组
     * @param curr curr控制当前递归层数
     * @param startIndex 为了避免下一轮的重复添加，控制下一层递归的起始位置。
     */
	private void searchSub(List<List<Integer>> result, int[] nums, int n, int[] cache, int curr, int startIndex) {
		for(int i = startIndex;i < n;++i) {
			cache[curr] = nums[i];
			addOneAns(result, cache, curr + 1);
			searchSub(result, nums, n, cache, curr + 1, i + 1);
		}
		
	}
	
	/**
	 * 将当前cache数组内的元素作为一个子集合结果放入result这中
	 * @param result
	 * @param cache
	 * @param curr
	 */
	private void addOneAns(List<List<Integer>> result, int[] cache, int curr) {
		List<Integer> oneAns = new ArrayList<>();
		for(int i = 0;i < curr;++i) {
			oneAns.add(cache[i]);
		}
		result.add(oneAns);
	}

}
