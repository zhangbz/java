class ArrayTest6 
{
	public static void main(String[] args) 
	{
		toHex(-60);
        toBin(6);
		//System.out.println("Hello World!");
	}

    /*
     * 10to2
     */
    public static void toBin(int number)
    {
        char[] chs = {'0', '1'};
        char[] arr = new char[32];
        int pos = arr.length;

        while(number != 0)
        {
            int temp = number & 1;
            arr[--pos] = chs[temp];
            number = number >>> 1;
        }

        for(int i = pos; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }
    }
	/*
	0 1 2 3 4 5 6 7 8 9 A  B  C  D  E  F		十六进制中的元素
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	
	 查表法：将所有的元素临时存储起来，建立对应关系。
	 每一次&15后的值作为索引去查建立好的表。就可以找到对应的元素。
	 这样比-10+'A'简单得多。
	
	 可以通过数组来定义表。
	 可以用StringBuffer reverse翻转
	 或使用数组
	*/
    public static void toHex(int num)
	{
		char[] chs = {'0', '1', '2', '3', 
			          '4', '5', '6', '7', 
			          '8', '9', 'A', 'B', 
			          'C', 'D', 'E', 'F'}; 
		//定义一个临时容器
		char[] arr = new char[8];
		int pos =arr.length;
		while(num != 0)		
		{
			int temp = num & 15;
			//System.out.println(chs[temp]);
			arr[--pos] = chs[temp];
			num = num >>> 4;
		}

		for (int x=pos;x<arr.length;x++ )
		{
			System.out.print(arr[x]);
		}
	}
}
