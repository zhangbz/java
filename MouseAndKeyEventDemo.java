import java.awt.*;
import java.awt.event.*;

class MouseAndKeyEventDemo
{
    //定义该图形中所需的组建的引用
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
		
		//对frame进行基本设置
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(20);
		
		but = new Button("my button");
		
		//将组件添加到frame中
		f.add(tf);
        f.add(but);

        //加载一下窗体上的事件
		myEvent();
		
		//显示窗体
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
				    System.out.println(code + "...是非法的");
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
			    System.out.println("鼠标进入到该组件" + count++);
			}
            public void MouseClicked(MouseEvent e)
            {
			    if(e.getClickCount() == 2)
				    System.out.println("双击动作" + clickCount++);
			}			
		});
		
	}
	
	public static void main(String[] args)
	{
	    new MouseAndKeyEventDemo();
	}
}