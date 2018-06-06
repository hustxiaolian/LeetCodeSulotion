package xiaolian.easy;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord2("xioa "));
	}
	
	/**
	 * 第一个思路：
	 * 直接调用String.split()方法
	 * @param s
	 * @return
	 */
    public static int lengthOfLastWord1(String s) {
        String[] arr = s.split(" ");
        if(arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }
    
    /**
     * 第二个思路：
     * 倒序搜索，
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
    	int n = s.length();
    	if(n == 0)	return 0;
    	int i = n - 1;
    	
    	for(;i >=0;--i) {
    		if(s.charAt(i) != ' ')
    			break;
    	}
    	if(i < 0)
    		return 0;
    	
    	int j = i;
    	for(;j >= 0;--j) {
    		if(s.charAt(j) == ' ')
    			break;
    	}
    	return i - j;
    }
}
