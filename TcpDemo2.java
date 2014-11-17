import java.io.*;
import java.net.*;

class  TcpClient2
{
	public static void main(String[] args) throws Exception 
	{
		Socket s = new Socket("169.254.75.71", 10004);

		OutputStream out = s.getOutputStream();
		
		out.write("服务器端，你好。".getBytes());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		s.close();
	}
}


class TcpServer2
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10004);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		OutputStream out = s.getOutputStream();

		out.write("哥们，你也好。".getBytes());

		ss.close();
	}
}