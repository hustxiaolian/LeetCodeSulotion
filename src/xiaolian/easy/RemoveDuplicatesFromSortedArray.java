package xiaolian.easy;


import java.util.TreeSet;

import xiaolian.medium.RemoveDuplicatesfromSortedArrayII;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·ֱ��ʹ��TreeSet
	 * �򵥴ֱ����õľ���set�м��ϲ��ظ������ԡ�
	 * 
	 * test1:25ms, beats 7.57%(��=��=��=��(�b��b;)��)
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
	 * ˼·��
	 * ��ͷ��β����Ԫ�أ�������һ���ľ�ת�Ƶ�ǰ��ȥ��
	 * 
	 * test1:13ms, beats 96.74%(��=��=��=��(�b��b;)��)
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
	 * ˼·��
	 * {@link RemoveDuplicatesfromSortedArrayII}
	 * ����˼·Ҳ�����㹻�򵥴ֱ��ġ�
	 * ��������ȫһ����
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
