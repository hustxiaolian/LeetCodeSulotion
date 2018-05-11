package xiaolian.medium;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * @author 25040
 *
 *
 *Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
	}
	
	/**
	 * ���ȣ������˵����д�ˣ��϶��д𰸣���ˣ�����ʡ��һЩ��������������
	 * ��ʵ������Ŀ��ThreeSum�ǵ���ǳ����ơ���ȫ�������ǵ����˼·������������������û��������ɧ������
	 * ˼·��ǰ����ȫ���ƣ��ٸ�ϰ�����°ѣ�
	 * the idea is:�������������ָ�룬��һ��i�����ұ������ڶ���j = i+1, ������k = n-1.�����������м��ƶ���
	 * �ж�������ָ��ָ���������ӵĺ� - target �Ƿ���ϴ�result��С��
	 * 
	 * bug 1 result��ʼ��ΪInteger.max_value��ʹ�����target���Ϊ������ֱ�������
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		int tail = nums.length - 1;
		int i,j,k,numi,sum;
		
		Arrays.sort(nums);
		outer:
		for(i = 0;i < tail - 1;) {
			numi = nums[i];
			j = i + 1;
			k = tail;
			while(j < k) {
				sum = numi + nums[j] + nums[k];
				if(sum < target) {
					++j;
					if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
				}
				else if(sum > target) {
					--k;
					if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
				}
				else if(sum == target) {
					result = sum;
					break outer;//��ȵĻ���ֱ���˳�����ѭ������Ϊ�����Ѿ���ȫ����ˡ�
				}
			}
			while(nums[i] == nums[++i] && i < tail - 1);//�����ظ���Ԫ��
		}
		
        return result;
    }

}
