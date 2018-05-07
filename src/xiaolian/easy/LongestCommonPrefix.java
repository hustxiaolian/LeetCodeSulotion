package xiaolian.easy;


/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * ˼·��
 * 1. �ȴ�����ʱ�ַ���
 * 2. �ѵ�һ���ַ����ĵ�i�����룬���μ����������ַ�����i���ַ����Ƿ�contain
 * 
 * ʱ�临�Ӷȣ�M(����������ַ������ַ���) * N(�������ַ���������)
 * �ռ临�Ӷȣ�M
 * 
 * ps:ע�������������Ĵ���
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = {"c", "c"};
		System.out.println(solution1(in));
	}
	
	/**
	 * ˼·�򵥴ֱ���ûɶ��˵�ġ�
	 * ע�������������������Ĵ���
	 * 1. ��input����nullʱ��ֱ�ӷ���null
	 * 2. ���input�ַ������������κ�һ��null�����ؿ��ַ���
	 * 3. ��inputֻ��һ���ַ��������ظ��ַ���
	 * 
	 * @param strs
	 * @return
	 */
	public static String solution1(String[] strs) {
		/*��ʼ������*/
		String buf = "";
		String submit_str = "";
		int i = -1, j = 1;
		
		/*�жϴ����������*/
		if(strs == null) {
			return null;
		}
		if(strs.length == 0) {
			return submit_str;
		}
		if(strs.length == 1) {
			return strs[0];
		}
		
		/*��������˼·����һ�����*/
		while(true) {
			//���ȱ�֤�����ַ����̣����ȱ�֤���ַ�������null,�ٱ�֤��Խ�����
			if(strs[0] != null && ((++i) < strs[0].length())) {
				//��ȡ�ж�����ûԽ��
				buf = buf.concat(strs[0].substring(i, i + 1));
			}
			else {
				//Խ���ˣ�ֱ���˳�
				break;
			}
			//���η��ʺ��������ַ������鿴��i��λ�ö�ͨbuf�е���ͬ,��Ȼ�����������ȱ�֤��Խ��
			for(j = 1;j < strs.length; ++j) {
				//�ڱ�֤input[j]����null�����ʲ�Խ�������£����жϵ�i��λ���Ƿ����
				if(strs[j] != null && i < strs[j].length() && buf.charAt(i) == strs[j].charAt(i)) {
					continue;
				}
				else {
					break;
				}
			}
			//�ж������Ǹ�ѭ�����Ƿ��ǲ��������˳������ǵĻ����˳���ѭ��
			if(j != strs.length) {
				break;
			}
			else {
				submit_str = buf;
			}
		}
		return submit_str;
	}

}
