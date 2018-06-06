package xiaolian.medium;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump2(new int[] {0,2}));
	}
	
	/**
	 * ˼·��
	 * ���ʼ��λ�ÿ�ʼ���ݹ������·���������ȴ�����������С����ֻҪ�ҵ�һ�����Ϸ���true
	 * �����뻭ͼ��⣬ͬʱ���õݹ�����ԣ�����ɵݹ���
	 * 
	 * bug 1:һ��ʼ����̫��ֱ������ȥ
	 * test1:time excuted out!̫���ˡ�Ҳ�����һ���ֻ�ܵ�Ѱ�����·����
	 * 
	 * @param nums
	 * @return
	 */
    public static boolean canJump1(int[] nums) {
    	int tail = nums.length - 1;
        return seerchPath1(nums, 0, tail);
    }

	private static boolean seerchPath1(int[] nums, int i, int tail) {
		//��׼���Σ��ﵽĩβ��
		if(i == tail)
			return true;
		//������Ѱ���п��ܵ�����
		int nextStep = Math.min(nums[i], tail - i);
		for(;nextStep > 0; --nextStep) {
			if(seerchPath1(nums, i + nextStep, tail))
				return true;
		}
		return false;
	}
	
	/**
	 * �ڶ���˼·��
	 * ��ʵ������ϸ�۲��о�������Ծ������ɣ��ҿ��Է��֣���ȫ���԰�����ֿ�������
	 * ÿ�����ڣ�Ԫ�ش�С���ֳɵݼ������ơ�
	 * ����2 3 1 1 4�����Ϊ2 | 3 1 1 | 4��������
	 * ����2 3 1 1 2 �����Ϊ2 | 3 1 1 |2 | 4�ĸ����֡�
	 * ͬʱ��Ծֻ�����ڿ��ײ�֮�䣬�����ͼ����˲���Ҫ�ĵݹ顣���������ϸ��汾�������ǰ����Ĺ���
	 * 
	 * test1:8ms, beats 91.89%��=��=��=��(�b��b;)��
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
		return searchPath2(nums, 0, nums.length - 1);
	}

	private static boolean searchPath2(int[] nums, int i, int tail) {
		if(i >= tail)//��׼����
			return true;
		//��ǰ�����һ�����ײ�,����ĸ�൱���ֿ������ε�����ĳЩ��ĸ�������j����Сһ�����ײ�
		int j = i;
		while(j <= tail && nums[j] + j <= nums[i] + i) 
			++j;
		//����ͨ�����һ��Ԫ���Ƿ�Ϊ0���жϣ�ͨ���ײ�Ԫ���ܹ�Խ����ı߽�ﵽ��һ�������ж�
		if(j - 1 < tail && nums[i] + i <= j - 1)
			return false;
		return searchPath2(nums, j, tail);
	}

}
