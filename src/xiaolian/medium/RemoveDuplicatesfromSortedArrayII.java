package xiaolian.medium;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {1,1,2,2,2,2,3,4,4,5}));
	}
	
	/**
	 * ��һ��˼·��
	 * �����趨һ����������cnt
	 * һ��ɨ�赽�����������ϵ��ظ�Ԫ��ʱ��ִ�к���Ԫ����ǰ��ĸ��ǹ�����
	 * �գ������ˣ���Ϊʲô����˫ָ���ˡ�
	 * test1:2ms,beats 65.20% ��=��=��=��(�b��b;)��
	 * ����Ĺ����У��Լ�������ɺ�о���̫�������ܸо�����⣬����ôд�ر����º��鷳��
	 * 
	 * �ڶ���˼·��
	 * �ο���discuss����ֱ����Ҳ��
	 * ���ĺ���idea�������Ҳ����ص��������ж��ظ��ϣ����ǻ���һ���Ƕȣ�˼����
	 * �µ�������ֻ���������ظ��������Ҫ����������飬��������ҵĵ����ڶ�λ��
	 * ����ĩ������3��4����ô������һ��4�����ǿ��Դ��������ôΪ3��4��4��
	 * ֮�󣬺�����4�Ͳ��ܽ����ˡ����Ǳ�����Ŀ��ԣ���Ϊ����ʱ����ġ�������
	 * 
	 * {@link ���ڿ����������Ƶ���Ŀ}
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        int n = result;
        int i = 1, j = 1;
        int currRepeat = 1;
        while(i < n) {
        	if(nums[i - 1] == nums[i]) {
        		currRepeat++;
        		if(currRepeat > 2) {
        			++i;
        			while(i < n && nums[i] == nums[i - 1]) {
        				currRepeat++;
        				i++;
        			}
        			if(i >= n)
                		break;
        			currRepeat = 1;
        		}
        	}
        	else
        		currRepeat = 1;
        	
        	nums[j] = nums[i];
        	++j;++i;
        }
        return j;
    }
    
    /**
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
	   int i = 0;
	   for (int n : nums)
	      if (i < 2 || n > nums[i - 2])
	         nums[i++] = n;
	   return i;
	}

}
