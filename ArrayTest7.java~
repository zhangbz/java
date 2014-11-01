/*************************************************************************
	> File Name: ArrayTest7.java
	> Author: 
	> Mail: 
	> Created Time: 2014年10月22日 星期三 09时56分58秒
 ************************************************************************/

class ArrayTest7
{
    public static void main(String[] args)
    {
        toBin(6);
        toHex(6);
        toBa(6);
    }

    /*10to2*/
    public static void toBin(int num)
    {
        trans(num, 1, 1);
    }
    /*10to16*/
    public static void toHex(int num)
    {
        trans(num, 15, 4);
    }
    /*10to8*/
    public static void toBa(int num)
    {
        trans(num, 7, 3);
    }

    public static void trans(int num, int base, int offset)
    {
        char[] chs = new char[]{'0','1','2','3',
                                '4','5','6','7',
                                '8','9','A','B',
                                'C','D','E','F'};
        char[] arr = new char[32];
        int pos = arr.length;

        while(num != 0)
        {
            int temp = num & base;
            arr[--pos] = chs[temp];
            num = num >>> offset;
        }

        for(int i = pos; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }
    }
}
