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

	//��ȡ���ֵ����һ�ַ�ʽ
	//�ɲ����Խ���ʱ������ʼ��Ϊ0�أ����ԡ����ַ�ʽ��ʵ���ڳ�ʼ��Ϊ����������һ���Ǳꡣ
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