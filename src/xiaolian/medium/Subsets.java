package xiaolian.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Subsets().subsets(new int[] {}));
	}
	
	/**
	 * ��һ��˼·��
	 * �Բۣ��Ҳŷ���ûд˼·���ⲻ̫�á��Ժ���������ܼ򵥣�Ҳ����д˼·�ٱ��룬�������õ�ϰ�ߡ�
	 * ����idea��������������������е��Ӽ��ϣ���ô�������Կ���������ϵı��֣�֮ǰ����ͨ��k�������Ӽ�����
	 * Ԫ�صĸ���������ֱ���ڵݹ�����У�����������еĿ����ԡ�
	 * 
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int n = nums.length;
        if(n == 0) return result;
        int[] cache = new int[n];
        searchSub(result, nums, n, cache, 0, 0);
        return result;
    }
    
    /**
     * ÿ�ֵĵݹ��൱�ڶ���ÿ�������е�ǰ����λ���ϵĸ��ֿ����ԡ�
     * ע�⵽������û�б�׼�ݹ���ʽ�Ļ�׼����������Ļ�׼�������
     * startindex >= n ��return��
     * 
     * {@link Combination}
     * @param result ���ս��list
     * @param nums ��������
     * @param n ��ʾ���鳤�ȣ����Ʊ����߽�
     * @param cache �����������
     * @param curr curr���Ƶ�ǰ�ݹ����
     * @param startIndex Ϊ�˱�����һ�ֵ��ظ���ӣ�������һ��ݹ����ʼλ�á�
     */
	private void searchSub(List<List<Integer>> result, int[] nums, int n, int[] cache, int curr, int startIndex) {
		for(int i = startIndex;i < n;++i) {
			cache[curr] = nums[i];
			addOneAns(result, cache, curr + 1);
			searchSub(result, nums, n, cache, curr + 1, i + 1);
		}
		
	}
	
	/**
	 * ����ǰcache�����ڵ�Ԫ����Ϊһ���Ӽ��Ͻ������result����
	 * @param result
	 * @param cache
	 * @param curr
	 */
	private void addOneAns(List<List<Integer>> result, int[] cache, int curr) {
		List<Integer> oneAns = new ArrayList<>();
		for(int i = 0;i < curr;++i) {
			oneAns.add(cache[i]);
		}
		result.add(oneAns);
	}

}
