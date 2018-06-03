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
	 * 思路：利用波峰一个上调沿和一次下调沿的性质，来判断。
	 * 
	 * 具体步骤：
	 * 1. 先寻转前面两个波峰，没有两个波峰，就说明为0
	 * 2. 然后计算面积的时候，
	 * 
	 * test1:43ms, beats 6.66% ε=ε=ε=┏(゜ロ゜;)┛
	 * 可以，这就很6，首先感谢自己在状态这么不好的时候还能做出来，不过这效率也是无敌了。真是底下啊。
	 * 
	 * 第二个思路：
	 * 卧槽，我感觉这个思路很吊，其性质是，根据雨把这个凹凸不平的地方填满后，呈现出的图形必定不会是出现一个凹坑，只可能是凸台或者平原
	 * 那么沿用之前求最大水缸那道题的思路。真正的线性
	 * 
	 * 具体的思路：定义两个指针，从两端向中间移动。
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
    			//往回填坑
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
