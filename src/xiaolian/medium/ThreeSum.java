package xiaolian.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
改进思路：使用数组操作，尽量避免使用集合

*/
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums){
		
		return null;
	}
}



/**
 * 思路：
具体，和画图见java笔记本page 1.
1. 判断num的个数，必须大于等于3.不然提示后，直接退出返回null
2. 首先把前面两个数更新到map中，前面两个数，没啥好干的
3. 从第三个数开始，假设第i个数，首先从map中判断keySet是否包含它，包含则说明它能够和前面某两个数满足等式要求，输出结果；
4. 该数字依次和前面i-1个数字组成一个组合，更新map。
	
时间复杂度：N^2
空间复杂度：N^2(因为我们任意时刻都保留C2,N)

晕死，time limit
分析愿意：过度使用java一些集合框架，过多的不必要的函数调用以及臃肿的循环是性能低下的主要原因
 */

class OldThreeSum {
	
	

	public static void main(String[] args) {
		int[] arr = {-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
		List<List<Integer>> res = threeSum(arr);
		System.out.println(res);
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums){
		//初始化变量,并且判断特殊输入
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums == null || nums.length < 3) {
			System.out.println("input error:" + nums);
			return result;
		}
		HashMap<Integer, List<TwoNum>> map = new HashMap<>();
		
		
		//首先把前面一个数放入map并且计算其和的负值
		updateMap(map, nums[0], nums[1]);
		for(int i = 2;i < nums.length; ++i) {
			List<TwoNum> lst = map.get(nums[i]);
			if(lst != null) {//判断map中是否有满足条件的
				for (TwoNum twoNum : lst) {//找到了，构造结果
					List<Integer> oneResult = new ArrayList<>(3);
					oneResult.add(twoNum.num1);
					oneResult.add(twoNum.num2);
					oneResult.add(nums[i]);
					//构造完毕后，进行查重工作,不重复得话插入链表中
					resultAdd(map, oneResult, result);
					//查重通过，插入结果链表中
				}
			}
			//更新map
			for(int j = 0; j < i; ++j) {
				updateMap(map, nums[j], nums[i]);
			}

		}
		
		return result;
	}
	
	/**
	 * 查重，如果发现重复，直接返回，啥也不做；没重复就插入到result中
	 * @param map
	 * @param oneResult
	 * @param result
	 */
	private static void resultAdd(HashMap<Integer, List<TwoNum>> map, List<Integer> oneResult,
			List<List<Integer>> result) {
		for (List<Integer> resList : result) {
			if(isSameResult(resList, oneResult))
				return;
		}
		result.add(oneResult);
	}

	/**
	 * 
	 * @author 25040
	 *
	 */
	private static class TwoNum{
		int num1;
		int num2;
		
		public TwoNum(int num1, int num2) {
			super();
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + num1;
			result = prime * result + num2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TwoNum other = (TwoNum) obj;
			/*修改了对象相等的含义*/
			if(this.num1 == other.num1 && this.num2 == other.num2)
				return true;
			if(this.num1 == other.num2 && this.num2 == other.num1)
				return true;
			return false;
		}
		
		
	}
	
	/**
	 * 在条件判断失败的情况下，输入两个数来更新map。
	 * 思路：
	 * 1. 判断map的keyset中是否已经有-num1 - num2了。
	 * 2. 如果有则，在对应的list中插入;在插入的过程中判断该表项是否已经插入
	 * 		例如（num1, num2）和(num2, num1)，（1，2）和（1，2）当然也是一样的
	 * 3. 新建list插入到map中，再把num1和num2放入到twosum中
	 * @param map
	 * @param num1
	 * @param num2
	 */
	private static boolean updateMap(HashMap<Integer, List<TwoNum>> map, int num1, int num2) {
		List<TwoNum> lst = map.get(negSum(num1, num2));
		if(lst == null) {//1
			lst = new LinkedList<>();//2
			map.put(negSum(num1, num2), lst);//bug 1 忘记把链表放入map中，昨天没睡好，果然容易犯错
		}
		TwoNum newItem = new TwoNum(num1, num2);
		//循环检测该项是否已经包括，如果已经包含了直接返回
		for (TwoNum twoNum : lst) {
			if(newItem.equals(twoNum))
				return false;
		}
		lst.add(newItem);//3
		return true;
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int negSum(int num1, int num2) {
		return -(num1 + num2);
	}
	
	/**
	 * 检测原理就是判断arr1每个元素，arr2是否contain.
	 * 如果arr1得任何一个元素，arr2不包含就说明两者不同
	 * bug 2 重大bug，这样无法判断。必须双向判断，感觉使用不相交集类最好。这里我为了省事还是，还是加上双向.
	 * 原路就是：如果你得元素我都有，我得元素你全有，那我们肯定是一样得集合
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static boolean isSameResult(List<Integer> arr1, List<Integer> arr2) {
		for (Integer integer : arr1) {
			if(! arr2.contains(integer))
				return false;
		}
		for (Integer integer : arr2) {
			if(! arr1.contains(integer))
				return false;
		}
		return true;
	}
}


