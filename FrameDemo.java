import java.awt.*;
import java.awt.event.*;

class FrameDemo
{
    //�����ͼ����������齨������
	private Frame f;
	private Button but;
	
	FrameDemo()
	{
	    init();    
	}
	
	public void init()
	{
	    f = new Frame("my frame");
		
		//��frame���л�������
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		but = new Button("my button");
		
		//�������ӵ�frame��
        f.add(but);

        //����һ�´����ϵ��¼�
		myEvent();
		
		//��ʾ����
		f.setVisible(true);
	}
	
	private void myEvent()
	{
	    f.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
			{
			    System.exit(0);
			}
		});
	}
	
	public static void main(String[] args)
	{
	    new FrameDemo();
	}
}