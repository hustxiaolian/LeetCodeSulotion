package xiaolian.hard;


/**
 * 
 * @author 25040
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *  compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap2(new int[] {5,5,1,7,1,1,5,2,7,6}));
	}
	
	/**
	 * ˼·�����ò���һ���ϵ��غ�һ���µ��ص����ʣ����жϡ�
	 * 
	 * ���岽�裺
	 * 1. ��Ѱתǰ���������壬û���������壬��˵��Ϊ0
	 * 2. Ȼ����������ʱ��
	 * 
	 * test1:43ms, beats 6.66% ��=��=��=��(�b��b;)��
	 * ���ԣ���ͺ�6�����ȸ�л�Լ���״̬��ô���õ�ʱ������������������Ч��Ҳ���޵��ˡ����ǵ��°���
	 * 
	 * �ڶ���˼·��
	 * �Բۣ��Ҹо����˼·�ܵ����������ǣ�������������͹��ƽ�ĵط������󣬳��ֳ���ͼ�αض������ǳ���һ�����ӣ�ֻ������͹̨����ƽԭ
	 * ��ô����֮ǰ�����ˮ���ǵ����˼·������������
	 * 
	 * �����˼·����������ָ�룬���������м��ƶ���
	 * 
	 * @param height
	 * @return
	 */
	public static int trap2(int[] height) {
		int result = 0;
		int n = height.length;
		if(n <= 2) return 0;
		int left = 0, right = n - 1;
		int leftNum = height[0], rightNum = height[n - 1];
		int curr;
		while(left <= right) {
			if(leftNum > rightNum) {
				curr = height[right--];
				rightNum = Math.max(curr, rightNum);
				result += (rightNum - curr);
			}
			else {
				curr = height[left++];
				leftNum = Math.max(curr, leftNum);
				result += (leftNum - curr);
			}
		}
		return result;
	}
	
    public static int trap(int[] height) {
    	int result = 0;
    	int lastPeak = -1;
    	int n = height.length;
    	if(n == 0) return 0;
    	int[] num = new int[n];
    	boolean upFlag = true;
    	
    	for(int i = 0;i < n - 1; ++i) {
    		int curr = height[i];
    		num[i] = curr;
    		int next = height[i + 1];
    		if(curr > next && upFlag) {
    			upFlag = false;
    			//�������
    			if(lastPeak != -1) {
    				int temp = Math.min(height[lastPeak], curr);
    				for(int k = lastPeak + 1;k < i;++k) {
    					if(num[k] < temp)
    						num[k] = temp;
    				}
    				if(curr >= height[lastPeak])
    					lastPeak = i;
    			}
    			if(lastPeak == -1)
    				lastPeak = i;
    		}
    		else if(curr < next) 
    			upFlag = true;
    	}
    	num[n - 1] = height[n - 1];
    	if(lastPeak != -1 && upFlag) {
    		int temp = Math.min(height[lastPeak], height[n - 1]);
			for(int k = lastPeak + 1;k < n;++k) {
				if(num[k] < temp)
					num[k] = temp;
			}
    	}
    	
    	for(int i = 0;i < n; ++i)
    		result += (num[i] - height[i]);
    	return result;
    }

}
