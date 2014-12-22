package mymenu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyMenuTest
{
    private Frame f;
	private MenuBar bar;
	private TextArea ta;
	private Menu fileMenu;
	private MenuItem closeItem,openItem,saveItem;
	private FileDialog openDia,saveDia;
	private File file;
	
	MyMenuTest()
	{
	    init();
	}
	public void init()
	{
	    f = new Frame("my window");
		f.setBounds(300, 100, 500, 600);
		//f.setLayout(new FlowLayout());
		
		ta = new TextArea();
		bar = new MenuBar();
		
		fileMenu = new Menu("file");
		
		openItem = new MenuItem("Open");
		saveItem = new MenuItem("Save");
		closeItem = new MenuItem("Exit");

		openDia = new FileDialog(f, "open", FileDialog.LOAD);
		saveDia = new FileDialog(f, "save", FileDialog.SAVE);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);
		bar.add(fileMenu);
		
		f.setMenuBar(bar);
		f.add(ta);
		myEvent();
		
		f.setVisible(true);
	}
	private void myEvent()
	{
	    saveItem.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    if(file == null)
				{
				    saveDia.setVisible(true);
					
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if(dirPath == null || fileName == null)
					    return ;
					file = new File(dirPath, fileName);
				}
				
				try
				{
				    BufferedWriter bufw  = new BufferedWriter(new FileWriter(file));
					
					String text = ta.getText();
					
					bufw.write(text);
					//bufw.flush();
					bufw.close();
				}
				catch(IOException s)
				{
				    throw new RuntimeException("save failed");
				}
			}
		});
	    openItem.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				//System.out.println(dirPath+"..."+fileName);
				if(dirPath == null || fileName == null)
				    return;
				ta.setText("");
				file = new File(dirPath, fileName);
				
				try
				{
				    BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while((line = bufr.readLine())!=null)
					{
					    ta.append(line+"\r\n");
					}
					
					bufr.close();
				}
				catch(IOException s)
				{
				    throw new RuntimeException("read failed");
				}
			}
		});
	    closeItem.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    System.exit(0);
			}
		});
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
	    new MyMenuTest();
	}
}