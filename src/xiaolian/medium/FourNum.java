package xiaolian.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author 25040
 * 
 * Given an array nums of n integers and an integer target, are there elements a, b, c, 
 * and d in nums such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * [-5,-4,-3,-2,-1,0,0,1,2,3,4,5]
0
 */
public class FourNum {
	public static void main(String[] args) {
		System.out.println(fourSum(new int[] {-5,-4,-3,-2,-1,0,0,1,2,3,4,5}, 0));
	}
	
	/**
	 * 该思路借鉴了threeNum和ThreeNumClostest的思路，只是简单的举一反三，没什么特别的。
	 * 
	 * 原先的思路：
	 * 用两重嵌套的从两端到中间的循环，使时间界限为二次方。我的想法是，每次sum变化值最小的方向，即sum变化梯度最小。
	 * 但是，如果我的想法的缺陷是，如果输入数组的梯度都是一样的，那么判定sum == 0后，如何移动下一步非常恼火。
	 * 
	 * 看了其他人的评论：现在确实还没有能到二次方的方案，那么也就是只能先到三次方。
	 * @version 1.0 运行结果：61ms, beat 69.28%
	 * @version 2.0 
	 * 当然这个方案还有很大的优化空间。比如它完全可以判断前面两个数和以及target的相对大小来掠过一些明显不可能的情况。
	 * 运行结果：27ms beat 92.79%
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//初始化变量，并且处理特殊情况
		int tailNum = nums.length - 1;
		List<List<Integer>> result = new ArrayList<>();
		if(tailNum < 3) return result;//处理特殊情况
		
		//排序
		Arrays.sort(nums);
		//初始化四个指针
		int a, b;
		int p, q;
		int numa, numb, sum, maxThree, maxTwo;
		maxTwo = nums[tailNum] + nums[tailNum - 1];
		maxThree = maxTwo + nums[tailNum - 2];
		for(a = 0;a < tailNum - 2;) {
			numa = nums[a];
			if(numa + maxThree < target) {
				while(nums[a] == nums[++a] && a < tailNum - 2);
				continue;
			}
			if(numa + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
			for(b = a + 1; b < tailNum - 1;) {
				numb = nums[b];
				if(numa + numb + maxTwo < target) {
					while(nums[b] == nums[++b] && b < tailNum - 1);
					continue;
				}
				if(numa + numb + nums[b + 1] + nums[b + 2] > target) break;
				
				p = b + 1;
				q = tailNum;
				
				while(p < q) {
					sum = numa + numb + nums[p] + nums[q];
					if(sum < target)
						++p;
					else {
						if(sum > target)
							--q;
						else {
							result.add(new ArrayList<>(Arrays.asList(numa, numb, nums[p], nums[q])));
							while(nums[p] == nums[++p] && p < q);//掠过重复项
							while(nums[q] == nums[--q] && p < q);
						}
					}
				}
				while(nums[b] == nums[++b] && b < tailNum - 1);
			}
			while(nums[a] == nums[++a] && a < tailNum - 2);
		}
		
        return result;
    }
}
