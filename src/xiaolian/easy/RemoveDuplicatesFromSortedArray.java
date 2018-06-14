package xiaolian.easy;


import java.util.TreeSet;

import xiaolian.medium.RemoveDuplicatesfromSortedArrayII;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路直接使用TreeSet
	 * 简单粗暴利用的就是set中集合不重复的特性。
	 * 
	 * test1:25ms, beats 7.57%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * @param nums
	 * @return
	 */
	public int removeDuplicates1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        int i;
        for(i = 0;i < n; ++i) {
        	set.add(nums[i]);
        }
        i = 0;
        for (Integer num : set) {
			nums[i++] = num;
		}
        return set.size();
    }
	
	/**
	 * 思路：
	 * 从头到尾遍历元素，碰到不一样的就转移到前面去；
	 * 
	 * test1:13ms, beats 96.74%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
		int tail = nums.length - 1;
		if(tail < 0) return 0;
		int i, j, pre = nums[0],curr;
		for(i = 1,j = 1;i <= tail;++i) {
			curr = nums[i];
			if(curr != pre) {
				nums[j++] = curr;
				pre = curr;
			}
		}
		return j;
	} 
	
	/**
	 * 思路：
	 * {@link RemoveDuplicatesfromSortedArrayII}
	 * 这种思路也真是足够简单粗暴的。
	 * 基本上完全一样，
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates3(int[] nums) {
    	int n = nums.length;
        int i = 1,j = 1;
        for(;i < n;++i) {
        	if(nums[i] > nums[j - 1])
        		nums[j++] = nums[i];
        }
        return j;
    }

}
