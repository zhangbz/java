import java.awt.*;
import java.awt.event.*;

class AwtDemo
{
    public static void main(String[] args)
	{
	    Frame f = new Frame("my awt");
		f.setSize(500, 400);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());
		
		Button b = new Button("I am a button.");
		
		f.add(b);
		
		//f.addWindowListener(new MyWin());
		f.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
			{
			    System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
}

class MyWin extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
	{
	    //System.out.println("window closing----" + e.toString());
		System.exit(0);
	}
}