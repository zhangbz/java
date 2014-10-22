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
	0 1 2 3 4 5 6 7 8 9 A  B  C  D  E  F		ʮ�������е�Ԫ��
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	
	 ����������е�Ԫ����ʱ�洢������������Ӧ��ϵ��
	 ÿһ��&15���ֵ��Ϊ����ȥ�齨���õı��Ϳ����ҵ���Ӧ��Ԫ�ء�
	 ������-10+'A'�򵥵öࡣ
	
	 ����ͨ�������������
	 ������StringBuffer reverse��ת
	 ��ʹ������
	*/
    public static void toHex(int num)
	{
		char[] chs = {'0', '1', '2', '3', 
			          '4', '5', '6', '7', 
			          '8', '9', 'A', 'B', 
			          'C', 'D', 'E', 'F'}; 
		//����һ����ʱ����
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
