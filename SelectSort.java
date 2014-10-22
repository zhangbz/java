class  ArrayDemo3
{
	public static void main(String[] args) 
	{
		// 数组的操作：
		//获取数组中的元素

		//int[] arr  = new int[3];
		int[] arr = {3, 4, 8, 5, 9, 6, 7,};
         
		printArray(arr);
		/*
        //数组名.length
		for (int x = 0; x < arr.length; x++ )
		{
			System.out.println("arr[" + x + "]=" + arr[x] + ";");
		}
     		System.out.println("Hello World!");
		*/
	}
	//定义一个功能，用于打印数组中的元素。元素间用逗号隔开。
	public static void printArray(int [] arr)
	{
		System.out.print("[ ");
		for(int x = 0; x < arr.length; x++)
		{
			if(x != arr.length-1)
				System.out.print(arr[x]+ ", ");
			else
				System.out.println(arr[x] +" ]");
		}
	}
}
