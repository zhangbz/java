/*
  数组的查找操作
*/

class ArrayTest4 
{
	public static void main(String[] args) 
	{
		int[] arr = {2, 4, 6, 8, 19, 32, 45};
		int index = getIndex_2(arr, 8);
		System.out.println("index=" + index);
		//System.out.println("Hello World!");
	}

    public static int getIndex_2(int[] arr, int key)
	{
        int min = 0,max =arr.length-1,mid;
		while(min <= max)
		{
			mid = (max+min)>>1;
			if (key>arr[mid])
			{
				min = mid+1;
			}
			else if (key <arr[mid])
			{
				max = mid - 1;
			}
			else
				return mid;
		}
		return min;//插入8
	}
    /*
	折半的第二种方式。
	*/
	public static int halfSearch_2(int[] arr, int key)
	{
        int min = 0,max =arr.length-1,mid;
		while(min <= max)
		{
			mid = (max+min)>>1;
			if (key>arr[mid])
			{
				min = mid+1;
			}
			else if (key <arr[mid])
			{
				max = mid - 1;
			}
			else
				return mid;
		}
		return -1;
	}
	/*
	折半查找。提高效率，但是必须要保证该数组是有序数组。
	*/
	public static int halfSearch(int[] arr, int key)
	{
		int min,max,mid;
		min = 0;
		max = arr.length-1;
		mid = (min+max)/2;

		while(arr[mid] != key)
		{
			if(key> arr[mid])
			    min = mid+1;
			else if(key<arr[mid])
				max = mid-1;

			if(min>max)
				return -1;
			mid = (min+max)/2;
		}
		return mid;
	}
}
