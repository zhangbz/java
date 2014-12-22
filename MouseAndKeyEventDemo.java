import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEventDemo
{
    //�����ͼ����������齨������
	private Frame f;
	private Button but;
	private TextField tf;
	
	MouseAndKeyEventDemo()
	{
	    init();    
	}
	
	public void init()
	{
	    f = new Frame("my frame");
		
		//��frame���л�������
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(20);
		
		but = new Button("my button");
		
		//�������ӵ�frame��
		f.add(tf);
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
		tf.addKeyListener(new KeyAdapter()
		{
		    public void keyPressed(KeyEvent e)
			{
			    int code = e.getKeyCode();
				if(!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
				{
				    System.out.println(code + "...�ǷǷ���");
					e.consume();
				}
			}
		});
		but.addKeyListener(new KeyAdapter()
		{
		    public void keyPressed(KeyEvent e)
			{
			    if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
				    //System.exit(0);
					System.out.println("ctrl + enter is run ");
					
			    //System.out.println(KeyEvent.getKeyText(e.getKeyCode())+ "..." + e.getKeyCode());
			}
		});
		but.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    System.out.println("action ok");
			}
		});
		but.addMouseListener(new MouseAdapter()
		{
		    private int count = 1;
			private int clickCount = 1;
            public void mouseEntered(MouseEvent e)
            {
			    System.out.println("�����뵽�����" + count++);
			}
            public void MouseClicked(MouseEvent e)
            {
			    if(e.getClickCount() == 2)
				    System.out.println("˫������" + clickCount++);
			}			
		});
		
	}
	
	public static void main(String[] args)
	{
	    new MouseAndKeyEventDemo();
	}
}