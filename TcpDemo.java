import java.io.*;
import java.net.*;

class  TcpClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("169.254.75.71", 10003);

		OutputStream out = s.getOutputStream();

		out.write("tcp ge men lai le".getBytes());

		s.close();
	}
}

class TcpServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10003);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);

		System.out.println(new String(buf,0,len));

		s.close();
		ss.close();
	}
}
