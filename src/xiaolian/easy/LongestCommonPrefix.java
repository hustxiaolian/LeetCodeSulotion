package xiaolian.easy;


/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * 思路：
 * 1. 先创建临时字符串
 * 2. 把第一个字符串的第i个放入，依次检测后续所有字符串第i个字符串是否被contain
 * 
 * 时间复杂度：M(数组内最短字符串的字符数) * N(数组内字符串的数量)
 * 空间复杂度：M
 * 
 * ps:注意各种特殊情况的处理
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = {"c", "c"};
		System.out.println(solution1(in));
	}
	
	/**
	 * 思路简单粗暴。没啥好说的。
	 * 注意特殊情况的输入情况的处理：
	 * 1. 当input就是null时，直接返回null
	 * 2. 如果input字符串数组中有任何一个null，返回空字符串
	 * 3. 当input只有一个字符串，返回该字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static String solution1(String[] strs) {
		/*初始化变量*/
		String buf = "";
		String submit_str = "";
		int i = -1, j = 1;
		
		/*判断处理特殊情况*/
		if(strs == null) {
			return null;
		}
		if(strs.length == 0) {
			return submit_str;
		}
		if(strs.length == 1) {
			return strs[0];
		}
		
		/*按照上述思路处理一般情况*/
		while(true) {
			//首先保证提起字符过程，首先保证该字符串不是null,再保证不越界访问
			if(strs[0] != null && ((++i) < strs[0].length())) {
				//提取判断索引没越界
				buf = buf.concat(strs[0].substring(i, i + 1));
			}
			else {
				//越界了，直接退出
				break;
			}
			//依次访问后续所有字符串，查看第i个位置都通buf中的相同,当然首先依旧是先保证不越界
			for(j = 1;j < strs.length; ++j) {
				//在保证input[j]不是null，访问不越界的情况下，再判断第i个位置是否相等
				if(strs[j] != null && i < strs[j].length() && buf.charAt(i) == strs[j].charAt(i)) {
					continue;
				}
				else {
					break;
				}
			}
			//判断上面那个循环，是否是不是正常退出，不是的话，退出死循环
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
