import java.net.*;

class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		//1.����udp����ͨ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();
		
		//2.ȷ�����ݣ�����װ�����ݰ���DataGramPacket(bytep[] buf, int length, InetAddress, int port)
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("169.254.75.71"), 10000);
		
		//3.ͨ��socket���񣬽����е����ݰ����ͳ�ȥ��ͨ��send������
		ds.send(dp);
		
		//4.�ر���Դ
		ds.close();
	}	
}

class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		//1.����udp socket�������˵㡣
		DatagramSocket ds = new DatagramSocket(10000);
		
		//2.�������ݰ������ڴ洢���ݡ�
		byte[]  buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3. ͨ����������receive���������յ������ݴ������ݰ��С�
		ds.receive(dp);
		
		//4.ͨ�����ݰ��ķ�����ȡ���е����ݡ�
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		int port = dp.getPort();
		
		System.out.println(ip+"::"+data+"::"+port);
		
		//5.�ر���Դ��
		ds.close(); 
	}
}