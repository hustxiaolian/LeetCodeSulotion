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
�Ľ�˼·��ʹ�������������������ʹ�ü���

*/
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums){
		
		return null;
	}
}



/**
 * ˼·��
���壬�ͻ�ͼ��java�ʼǱ�page 1.
1. �ж�num�ĸ�����������ڵ���3.��Ȼ��ʾ��ֱ���˳�����null
2. ���Ȱ�ǰ�����������µ�map�У�ǰ����������ûɶ�øɵ�
3. �ӵ���������ʼ�������i���������ȴ�map���ж�keySet�Ƿ��������������˵�����ܹ���ǰ��ĳ�����������ʽҪ����������
4. ���������κ�ǰ��i-1���������һ����ϣ�����map��
	
ʱ�临�Ӷȣ�N^2
�ռ临�Ӷȣ�N^2(��Ϊ��������ʱ�̶�����C2,N)

������time limit
����Ը�⣺����ʹ��javaһЩ���Ͽ�ܣ�����Ĳ���Ҫ�ĺ��������Լ�ӷ�׵�ѭ�������ܵ��µ���Ҫԭ��
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
		//��ʼ������,�����ж���������
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums == null || nums.length < 3) {
			System.out.println("input error:" + nums);
			return result;
		}
		HashMap<Integer, List<TwoNum>> map = new HashMap<>();
		
		
		//���Ȱ�ǰ��һ��������map���Ҽ�����͵ĸ�ֵ
		updateMap(map, nums[0], nums[1]);
		for(int i = 2;i < nums.length; ++i) {
			List<TwoNum> lst = map.get(nums[i]);
			if(lst != null) {//�ж�map���Ƿ�������������
				for (TwoNum twoNum : lst) {//�ҵ��ˣ�������
					List<Integer> oneResult = new ArrayList<>(3);
					oneResult.add(twoNum.num1);
					oneResult.add(twoNum.num2);
					oneResult.add(nums[i]);
					//������Ϻ󣬽��в��ع���,���ظ��û�����������
					resultAdd(map, oneResult, result);
					//����ͨ����������������
				}
			}
			//����map
			for(int j = 0; j < i; ++j) {
				updateMap(map, nums[j], nums[i]);
			}

		}
		
		return result;
	}
	
	/**
	 * ���أ���������ظ���ֱ�ӷ��أ�ɶҲ������û�ظ��Ͳ��뵽result��
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
			/*�޸��˶�����ȵĺ���*/
			if(this.num1 == other.num1 && this.num2 == other.num2)
				return true;
			if(this.num1 == other.num2 && this.num2 == other.num1)
				return true;
			return false;
		}
		
		
	}
	
	/**
	 * �������ж�ʧ�ܵ�����£�����������������map��
	 * ˼·��
	 * 1. �ж�map��keyset���Ƿ��Ѿ���-num1 - num2�ˡ�
	 * 2. ��������ڶ�Ӧ��list�в���;�ڲ���Ĺ������жϸñ����Ƿ��Ѿ�����
	 * 		���磨num1, num2����(num2, num1)����1��2���ͣ�1��2����ȻҲ��һ����
	 * 3. �½�list���뵽map�У��ٰ�num1��num2���뵽twosum��
	 * @param map
	 * @param num1
	 * @param num2
	 */
	private static boolean updateMap(HashMap<Integer, List<TwoNum>> map, int num1, int num2) {
		List<TwoNum> lst = map.get(negSum(num1, num2));
		if(lst == null) {//1
			lst = new LinkedList<>();//2
			map.put(negSum(num1, num2), lst);//bug 1 ���ǰ��������map�У�����û˯�ã���Ȼ���׷���
		}
		TwoNum newItem = new TwoNum(num1, num2);
		//ѭ���������Ƿ��Ѿ�����������Ѿ�������ֱ�ӷ���
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
	 * ���ԭ������ж�arr1ÿ��Ԫ�أ�arr2�Ƿ�contain.
	 * ���arr1���κ�һ��Ԫ�أ�arr2��������˵�����߲�ͬ
	 * bug 2 �ش�bug�������޷��жϡ�����˫���жϣ��о�ʹ�ò��ཻ������á�������Ϊ��ʡ�»��ǣ����Ǽ���˫��.
	 * ԭ·���ǣ�������Ԫ���Ҷ��У��ҵ�Ԫ����ȫ�У������ǿ϶���һ���ü���
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


