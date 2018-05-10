package xiaolian.medium;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 2));
		/*
		if(new ZigZagConversion().convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI")) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		*/
	}
	
	/**
	 * 思路：
	 * 简单粗暴的线性：画图理解，我们可以从之字形的排列上发现一些数学规律。
	 * 我们可以简单的推导出它的数学公式。设n
	 * 1. 第一排图形的索引序列为0,2*(n-1),4(n-1)...
	 * 2. 最后一排索引序列为n-1,3*(n-1),5(n-1)...
	 * 3. 中间排的索引索引间隔是变化的，2*(n-1 -i),2*i，交替加这两个间隔，i为当前排数
	 * 
	 * test1:110ms
	 * test2:使用stringbuffer类，替代频繁的string类相加，提升巨大。54ms
	 * 
	 * 再想改进：只能把它放在数组中处理，近似于c语言。
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		int slength = s.length();
		int interval = numRows - 1;
		if(interval == 0 || slength == 0 || slength <= numRows)  return s;//处理特殊情况
		StringBuffer sb = new StringBuffer();
		int tempInterval;
		int i,j,row;
		
		//把第一排放入
		for(i = 0;i < slength; i += 2 * interval) {
			sb.append(s.charAt(i));
		}
		//中间排，由于序列间隔不均一，所以统一处理
		for(row = 1; row < numRows - 1; ++row) {
			for(i = 0, j = row;j < slength;j += tempInterval) {
				sb.append(s.charAt(j));
				tempInterval = 2 * (i++ % 2 == 0? (interval  - row): row); 
			}
		}
		//最后一排
		for(i = interval;i < slength; i += 2 * interval) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
    }
}
