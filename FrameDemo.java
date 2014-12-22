import java.awt.*;
import java.awt.event.*;

class FrameDemo
{
    //定义该图形中所需的组建的引用
	private Frame f;
	private Button but;
	
	FrameDemo()
	{
	    init();    
	}
	
	public void init()
	{
	    f = new Frame("my frame");
		
		//对frame进行基本设置
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		but = new Button("my button");
		
		//将组件添加到frame中
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
	}
	
	public static void main(String[] args)
	{
	    new FrameDemo();
	}
}