import java.util.*;
class ArrayTest2 
{
	public static void main(String[] args) 
	{
		int[] arr = {5, 1, 2, 4, 3, 9, 8, 7};
		selectSort(arr);
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);
		Arrays.sort(arr);
		printArr(arr);
		//System.out.println("Hello World!");
	}

    public static void selectSort(int[] arr)
	{
		/*
        ѡ������
		��ѭ������һ�Σ���ֵ������ͷ�Ǳ�λ���ϡ�
		*/
		for(int x = 0; x <arr.length-1; x++)
		{
			for(int y = x+1; y<arr.length; y++)
			{
				if(arr[x] > arr[y])
				{
					int temp = arr[x];
				    arr[x] = arr[y];
				    arr[y] = temp;
				}   
			}
		}
	}


    /*
	ð������
	���ڵ�����Ԫ�ؽ��бȽϣ��������������λ��
    ��һȦ����ֵ�����������λ�á�
	�������ϣ������3��ѭ��+λ����
	�����Ż������еĽ����ĵ�ջ��
	*/
	public static void bubbleSort(int[] arr)
	{
		for (int x = 0; x < arr.length-1; x++ )
		{
			for (int y = 0; y < arr.length-x-1; y++ )//-x:��ÿһ�αȽϵ�Ԫ�ؼ��٣� -1������Ǳ�Խ��
			{
				if(arr[y] > arr[y+1])
				{
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
	}

	public static void printArr(int[] arr)
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
