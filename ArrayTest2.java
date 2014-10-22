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
        选择排序。
		内循环结束一次，最值出现在头角标位置上。
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
	冒泡排序
	相邻的两个元素进行比较，如果符合条件换位。
    第一圈：最值出现在了最后位置。
	最快排序：希尔排序：3层循环+位运算
	性能优化：堆中的交换改到栈中
	*/
	public static void bubbleSort(int[] arr)
	{
		for (int x = 0; x < arr.length-1; x++ )
		{
			for (int y = 0; y < arr.length-x-1; y++ )//-x:让每一次比较的元素减少， -1：避免角标越界
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
