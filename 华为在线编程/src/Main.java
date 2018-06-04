import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;



public class Main {

	class A{}
	class B extends A{}
	class C extends A{}
	class D extends B{}
	
	public static void main(String[] args) {
		DecimalFormat dt = new DecimalFormat("#.0");
		System.out.println(dt.format(9.99));
		/**
		Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        String[] splits = line.split(" ");
        int iSortFlag = Integer.valueOf(splits[splits.length - 1]);
        Integer[] pIntegerArray = new Integer[splits.length - 1];
        for (int i = 0; i < pIntegerArray.length; i++){
            pIntegerArray[i] =Integer.valueOf(splits[i]);
        }
        sortIntegerArray(pIntegerArray, iSortFlag);
        for(int i = 0; i < pIntegerArray.length - 1; i++){
            System.out.print(pIntegerArray[i] + " ");
        }
        System.out.println(pIntegerArray[pIntegerArray.length - 1] + "");
        **/
	}
	
	/**
	 * 计算一个数字的立方根，不使用库函数
	 * @param input
	 * @return
	 */
	public static double getCubeRoot(double input) {
		return 0.0;
	}
	
	/**
	 * 字符逆序
	 * @param str
	 * @return
	 */
	public static String reverseStr(String str) {
		char[] splits = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = splits.length - 1; i >= 0; i-- ) {
			sb.append(splits[i]);
		}
		return sb.toString();
	}
	
	public static int GetResult(int num, int[] pInput) {
		// 排序
		for (int i = pInput.length; i >0; i--)
		{
			for (int j = 0; j < i - 1; j++) {
				if (pInput[j] > pInput[j + 1])
				{
					int tmp = pInput[j];
					pInput[j] = pInput[j+1];
					pInput[j+1] = tmp;
				}
			}
		}
		for (int i = 0; i < pInput.length; i++)
			System.out.println(pInput[i]);
		int count = 0;
		int bs = 0;
		for (int i = 1; i < pInput.length; i++)
		{
			if(bs == 0 || pInput[i] - pInput[i - 1] > bs )
			{
				count += 1;
				bs = pInput[i] - pInput[i - 1];
			}
		}
		return count;
	}
	public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
        for (int i = 1; i < pIntegerArray.length; i++)
        {
            int tmp = pIntegerArray[i];
            int j = i;
            for(; j > 0; j--) {
                if (pIntegerArray[j - 1] > tmp && iSortFlag == 0)
                {
                    pIntegerArray[j] = pIntegerArray[j - 1];
                }
                else if (pIntegerArray[ j - 1] < tmp && iSortFlag == 1){
                    pIntegerArray[j] = pIntegerArray[j - 1];
                }
                else {
                    break;
                }
            }
            pIntegerArray[j] = tmp;
        }
    }
	
	public static int CalcAutomorphicNumbers(int n) {
		int r = 0;
		for (int i = 0; i <= n; i++) {
			int j = 10;
			while (i / j != 0) {
				j *= 10;
			}
			if ((i * i - i) % j == 0)
				r++;
		}
		return r;
	}
	
	/**
	 * 坐标移动
	 * @param line
	 */
	public static void move(String line)
	{
		String[] splits = line.split(";");
		int x = 0, y = 0;
		for (String s : splits)
		{
			if (s.equals("") || s == null)
				continue;
			char d = s.charAt(0);
			int distance = 0;
			try 
			{
				distance = Integer.valueOf(s.substring(1, s.length()));
			} 
			catch (Exception e)
			{
				continue;
			}
			 switch(d)
			 {
			 case 'A':
				 x -= distance;
				 break;
			 case 'S':
				 y -= distance;
				 break;
			 case 'W':
				 y += distance;
				 break;
			 case 'D':
				 x += distance;
				 break;
			 }
		}
		System.out.println(x + "," + y);
	}
	
	public static String checkPassword(String password){
		// check length
		if (password.length() < 8)
			return "NG";
		// check char kind num
		int count = 0;
		if (password.matches("[0-9]+"))
			count += 1;
		if (password.matches("[a-z]+"))
			count += 1;
		if (password.matches("[A-Z]+"))
			count += 1;
		for (int i = 0; i < password.length(); i++)
		{
			char c = password.charAt(i);
			if ( !((int) c >= '0' && (int) c <= '9') || ((int) c >= 'a' && (int)  c <= 'Z'))
			{
				count += 1;
				break;
			}
		}
		if (count < 3)
			return "NG";
		// check nopeat > 2
		for (int i = 0; i < password.length() - 3; i++)
		{
			for (int j = i + 2; j < password.length() - 1; j++)
			{
				if (password.charAt(i) == password.charAt(j) && (password.charAt(i + 1) == password.charAt(j + 1)))
				{
					return "NG";
				}
			}
		}
		return "OK";
	}
	
	/**
	 * 从字符串中移除出现次数最少的字符
	 * @param input
	 * @return
	 */
	public static String removeMinChar(String input)
	{
		Map<Character, Integer> m= new LinkedHashMap<>();
		char[] A = input.toCharArray();
		for (char c : A)
		{
			if (!m.containsKey(c))
				m.put(c, 1);
			else
				m.put(c,  m.get(c) + 1);
		}
		Collection<Integer> al = m.values();
		int index = Collections.min(al);
		StringBuffer sb = new StringBuffer();
		for (char c: A)
		{
			if (m.get(c) != index)
				sb.append(c);
		}
		return sb.toString();
	}
}
