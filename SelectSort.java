class  ArrayDemo3
{
	public static void main(String[] args) 
	{
		// ����Ĳ�����
		//��ȡ�����е�Ԫ��

		//int[] arr  = new int[3];
		int[] arr = {3, 4, 8, 5, 9, 6, 7,};
         
		printArray(arr);
		/*
        //������.length
		for (int x = 0; x < arr.length; x++ )
		{
			System.out.println("arr[" + x + "]=" + arr[x] + ";");
		}
     		System.out.println("Hello World!");
		*/
	}
	//����һ�����ܣ����ڴ�ӡ�����е�Ԫ�ء�Ԫ�ؼ��ö��Ÿ�����
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
