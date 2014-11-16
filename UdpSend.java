import java.net.*;

class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		//1.创建udp服务，通过DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket();
		
		//2.确定数据，并封装成数据包，DataGramPacket(bytep[] buf, int length, InetAddress, int port)
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("169.254.75.71"), 10000);
		
		//3.通过socket服务，将已有的数据包发送出去。通过send方法。
		ds.send(dp);
		
		//4.关闭资源
		ds.close();
	}	
}

class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		//1.创建udp socket，建立端点。
		DatagramSocket ds = new DatagramSocket(10000);
		
		//2.定义数据包，用于存储数据。
		byte[]  buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3. 通过服务器的receive方法，将收到的数据存入数据包中。
		ds.receive(dp);
		
		//4.通过数据包的方法获取其中的数据。
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		int port = dp.getPort();
		
		System.out.println(ip+"::"+data+"::"+port);
		
		//5.关闭资源。
		ds.close(); 
	}
}