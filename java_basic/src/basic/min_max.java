package basic;

public class min_max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3, b = 5;
		int max = 0;
		if (a > b)
			max = a;
		else
			max = b;
	}

	{
		int a = 3, b = 5;
		int max = 0;
		max = a > b ? a : b;
	}
	{
		int a = 3, b = 5;
		int max = Math.max(a, b);// 실수를 줄임
	}
	{
		int min = Integer.MAX_VALUE;
		int[] intArray = { 1, 3, 5, 7 };
		for (int i = 0; i < intArray.length; i++) {
			min = Math.min(min, intArray[i]);
		}
	}
	{
		int max = Integer.MIN_VALUE;
		int[] intArray = { 1, 3, 5, 7 };
		for (int i = 0; i < intArray.length; i++) {
			max = Math.max(max, intArray[i]);
		}
	}

}
