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
	 * ��˼·�����threeNum��ThreeNumClostest��˼·��ֻ�Ǽ򵥵ľ�һ������ûʲô�ر�ġ�
	 * 
	 * ԭ�ȵ�˼·��
	 * ������Ƕ�׵Ĵ����˵��м��ѭ����ʹʱ�����Ϊ���η����ҵ��뷨�ǣ�ÿ��sum�仯ֵ��С�ķ��򣬼�sum�仯�ݶ���С��
	 * ���ǣ�����ҵ��뷨��ȱ���ǣ��������������ݶȶ���һ���ģ���ô�ж�sum == 0������ƶ���һ���ǳ��ջ�
	 * 
	 * ���������˵����ۣ�����ȷʵ��û���ܵ����η��ķ�������ôҲ����ֻ���ȵ����η���
	 * @version 1.0 ���н����61ms, beat 69.28%
	 * @version 2.0 
	 * ��Ȼ����������кܴ���Ż��ռ䡣��������ȫ�����ж�ǰ�����������Լ�target����Դ�С���ӹ�һЩ���Բ����ܵ������
	 * ���н����27ms beat 92.79%
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//��ʼ�����������Ҵ����������
		int tailNum = nums.length - 1;
		List<List<Integer>> result = new ArrayList<>();
		if(tailNum < 3) return result;//�����������
		
		//����
		Arrays.sort(nums);
		//��ʼ���ĸ�ָ��
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
							while(nums[p] == nums[++p] && p < q);//�ӹ��ظ���
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
