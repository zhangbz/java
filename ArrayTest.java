class  ArrayTest
{
	public static void main(String[] args) 
	{
		int [] arr = {1, 3, 4, 2, 8, 6, 7,9};
		
		int max = getMax(arr);
		int min = getMin(arr);
		System.out.println("max = " + max);
		2014/10/20System.out.println("min = " + min);
		//System.out.println("Hello World!");
	}

	public static int getMax(int[] arr)
	{
	    int max = arr[0];

		for(int x = 1; x < arr.length; x++)
		{
		    if(arr[x] > max)
				max = arr[x];
		}
		return max;	
	}

	//获取最大值的另一种方式
	//可不可以将临时变量初始化为0呢？可以。这种方式其实是在初始化为数组中任意一个角标。
    public static int getMin(int[] arr)
	{
	    int min = 0;

		for(int x = 1; x < arr.length; x++)
		{
		    if(arr[x] < arr[min])
				min = x;
		}
		return arr[min];	
	}
}