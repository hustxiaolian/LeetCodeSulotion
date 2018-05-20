package xiaolian.medium;

/**
 * 
 * @author 25040
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextPermutation(new int[] {5,4,7,5,3,2});
	}
	
	/**
	 * ˼·��
	 * 1. ����һ����̬�жϵĹ��̣���β����ʼ�ж��Ƿ���һ�������Ƿ�ȵ�ǰ�Ĵ󣬴�ͼ�����ǰ�жϣ�ֱ���ҵ�һ��
	 * ����������������ֹͣ���������ͺ�׺��һ�����֣�������ֻ�����Դ󡣣���Ȼ��Ӻ�������ֽ���������
	 * 
	 * test1:22ms, beats 21.87%(��=��=��=��(�b��b;)��)
	 * test2:20ms, beats 63.89%(��=��=��=��(�b��b;)��)
	 * 
	 * ���꣬���ν������һ��仯��û�У�˼·��һ��������е��
	 * ���⣬���˴𰸣�˼·���һ���һ�¡�
	 * 
	 * ���ַ��ĸĽ�˼·�����ڣ�������ַǳ����ʱ�򣬷������Ż�Ч�������ԣ�������ʡʱ�仹�����������ò����ķ���
	 * 
	 * test3:19ms ,beats 90.71%(��=��=��=��(�b��b;)��)����Ŷ����������ѧ�仯��
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		int n = nums.length;
        if(n <= 1) return;
        
        int i, j, temp1, temp2;
        for(i = n - 1; i > 0; --i) {
        	if(nums[i - 1] < nums[i])
        		break;
        }
        if(i <= 0) {
        	//û���ҵ�����������ˣ������ص���С��
        	reserveSort(0, n -1, nums);
            return;
        }
        j = i;
        temp1 = nums[i - 1];
        //���ڿ��ԸĽ�Ϊ������������Ϊ����������ġ�
        while(j < n && temp1 < nums[j])
        	j++;
        temp2 = nums[j - 1];
        
        nums[i - 1] = temp2;
        nums[j - 1] = temp1;
        
        //�������ǵ�˳��
        reserveSort(i, n - 1, nums);
    }
	
	/**
	 * ���������뷶Χ�ڵ����֡�
	 * @param i
	 * @param j
	 * @param nums 
	 */
	private static final void reserveSort(int i, int j, int[] nums) {
		int temp;
		for(;i < j; ++i, --j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
	}
	
	@SuppressWarnings("unused")
	private final static int binarySearch(int start, int end, int val, int[] nums) {
		if(start == end) {
			return start;
		}
		if(nums[end] > val)
			return end;
		
		while(start + 1 != end) {
			int mid = (start + end) / 2;
			if(val > nums[mid])
				start = mid;
			else
				end = mid;
				
		}
		
		if(nums[end] <= val)
			return start;
		else 
			return end;
	}
}
