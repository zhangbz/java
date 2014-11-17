import java.io.*;
import java.net.*;

class  TransClient
{
	public static void main(String[] args) throws Exception 
	{
		Socket s = new Socket("169.254.75.71",10006);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		//BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while((line = bufr.readLine())!= null)
		{
			if("over".equals(line))
				break;
			
			//bufOut.write(line);
			//bufOut.newLine();
			//bufOut.flush();
			out.println(line);

			String str = bufIn.readLine(); 
            System.out.println("server:"+str);
		}

		bufr.close();
		s.close();   //��socket�������һ��-1(�������)�����·�������readLineҲ����-1��������
	}
}

class TransServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10006);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		BufferedReader bufIn= new BufferedReader(new InputStreamReader(s.getInputStream()));

		//BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		String line = null;

		while((line = bufIn.readLine())!= null)
		{
			//bufOut.write(line.toUpperCase());
			//bufOut.newLine();
			//bufOut.flush();
			out.println(line.toUpperCase());
		}

		s.close();
		ss.close();
	}
}