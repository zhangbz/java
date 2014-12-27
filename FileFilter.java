import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class FileFilter
{
    //��Ա����
    private JFrame f,f2;
    private JLabel l,lab;
    private JPanel p,p_b;
    private JButton bt_add,bt_rm,bt_scan;
    private JCheckBox cb;
    private FileDialog openDia;
    private File file, dir;
    private JFileChooser fc;
    private ArrayList<JCheckBox> cbal;
    private JTextArea ta;

    //���캯��
    public FileFilter()
    {
        //��ʼ��
        init();
    }
	
    //��ʼ������
    private void init()
    {
        f = new JFrame("FileFilter");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setBounds(300, 100, 600, 500);
		
	l = new JLabel("�����б�");
		
	p = new JPanel();
	p.setLayout(new GridLayout(10,1));
		
	cbal = new ArrayList<JCheckBox>();
		
	p_b = new JPanel(new GridLayout(1,3));
		
	bt_add = new JButton("Add");
	bt_rm = new JButton("Remove");
	bt_scan = new JButton("Scan");
		
	p_b.add(bt_add);
	p_b.add(bt_scan);
	p_b.add(bt_rm);
		
	fc = new JFileChooser();
	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
	openDia = new FileDialog(f, "open", FileDialog.LOAD);
		
	ta = new JTextArea(10,10);
		
	f.add(l, BorderLayout.NORTH);
	f.add(p, BorderLayout.WEST);
	f.add(ta, BorderLayout.CENTER);
	f.add(p_b,BorderLayout.SOUTH);
		
	myEvent();
		
	f.setVisible(true);
    }
	
	//�¼�
	private void  myEvent()
	{
	    //��ť���¼�
	    bt_rm.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    for(JCheckBox cb: cbal)
				{
				    if(cb.isSelected())
					{
					    cb.setVisible(false);
						p.remove(cb);
						cb.setSelected(false);
					}
				}
			}
		});
	    bt_scan.addActionListener(new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    ta.setText("");
			    for( JCheckBox cb : cbal)
				{
				    
				    if(cb.isSelected())
					{
						dir = new File(cb.getText());
						File[] fl = dir.listFiles();
						//System.out.println(fl.length);
						for(int i = 0; i < fl.length - 1; i++ )
						{
							if(check(fl[i]))
								continue;
							for(int j = i+1; j < fl.length; j++)
							{
								compare(fl[i], fl[j]);
							}	   
						}
						
						for(int i = 0; i < fl.length; i++ )
						{
						    if(fl[i].getName().startsWith("resultAbout"))
							{
							    show(fl[i]);
							}
						}
					}				
				}
			}
		});
	    bt_add.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
			{
			    fc.showOpenDialog(f);
				String dirPath = fc.getSelectedFile().toString();
                
                if(dirPath == null )
                    return;
                
				file = new File(dirPath);
				
				cb = new JCheckBox(dirPath);
				cb.setSelected(true);
				p.add(cb);
				cbal.add(cb);
				p.updateUI();
				
			}
		});
	}
	
	//��ʾ���
	private void show(File f)
	{		
		File file = new File(f.getAbsoluteFile().toString());
				
		if(file.exists())
		{
			try
			{
				BufferedReader bufr = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = bufr.readLine())!=null)
				{
					ta.append(line+"\r\n");
				}
				ta.append("-----------------------------------
				           -----------------------------\r\n");
				bufr.close();
			}
			catch(IOException s)
			{
				throw new RuntimeException("read failed");
			}
		}
		else
		{
		}
	}
	
	//�ļ��Ƚ�
	private void compare(File file1, File file2)
	{
	    try
		{
			FileInputStream fis1 = new FileInputStream(file1.getAbsoluteFile().toString());
			FileInputStream fis2 = new FileInputStream(file2.getAbsoluteFile().toString());
			int len1 = fis1.available();
			int len2 = fis2.available();
			if(len1 == len2) 
			{
				byte[] data1 = new byte[len1];
				byte[] data2 = new byte[len2];
				
				fis1.read(data1);
				fis2.read(data2);
				
				for(int i = 0; i < len1; i++)
				{
					if(data1[i] != data2[i])
					{
						//System.out.System.out.println(file1.getAbsoluteFile().toString() 
						                  //  + file2.getAbsoluteFile().toString() + "�ļ����ݲ�һ��");
						return;
					}
				}
				//System.out.println(file1.getAbsoluteFile().toString() 
				                  //  + file2.getAbsoluteFile().toString() +  "�ļ�����һ��");
				result(file1.getAbsoluteFile().toString(), file2.getAbsoluteFile().toString());
				
			}
			else
			{
			   // System.out.println(file1.getAbsoluteFile().toString() 
				              //      + file2.getAbsoluteFile().toString() +  "�ļ����ݲ�һ��");
			}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
	    
	}
	
	//���������ļ�
	public void result(String fileName1, String fileName2)
	{
		String resultPath = dir + "\\resultAbout" + new File(fileName1).getName() + ".txt";
		File resultFile = new File(resultPath);
		if(!resultFile.exists())
		{
			FileOutputStream fos = null;
			try
			{
			    resultFile.createNewFile();
			    fos = new FileOutputStream(resultFile, true); 
				byte[] b1 = fileName1.getBytes();
				byte[] b2 = "\r\n".getBytes();
				byte[] b3 = fileName2.getBytes();
				
				fos.write(b1);
				fos.write(b2);
				fos.write(b3);
				fos.write(b2);
				
			}
			catch(Exception e)
			{
			    e.printStackTrace();
			}
			finally
			{
			    try
				{
				    fos.close();
				}
				catch(Exception e)
				{
				}
			}

		}
		else
		{
			FileOutputStream fos = null; 

			try
			{
			    fos = new FileOutputStream(resultFile, true); 
				byte[] b1 = fileName2.getBytes();
				byte[] b2 = "\r\n".getBytes();
				fos.write(b1);
				fos.write(b2);
				
			}
			catch(Exception e)
			{
			    e.printStackTrace();
			}
			finally
			{
			    try
				{
				    fos.close();
				}
				catch(Exception e)
				{
				}
		    }
		}
	}
	
	//�ж��ļ��Ƿ��Ѿ������
	private boolean check(File cf)
	{
		File[] resultAboutFileList = dir.listFiles();
		for(int i = 0; i < resultAboutFileList.length; i++)
		{
			if(!resultAboutFileList[i].getName().startsWith("resultAbout"))
			{
				resultAboutFileList[i] = null;
			}
		}
		
		for(int i = 0; i < resultAboutFileList.length; i++)
		{
		    if(resultAboutFileList[i] != null)
			{
				FileInputStream fis = null;
				FileReader reader = null;
				BufferedReader br = null;
				try
				{
					String str = null;
					reader = new FileReader(dir + "\\" + resultAboutFileList[i].getName().toString());
					br = new BufferedReader(reader);
					while((str = br.readLine()) != null)
					{
					    //System.out.println(str);
						if(str.equals(cf.getAbsoluteFile().toString()))
							return true;			
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						br.close();
						reader.close();	
					}
					catch(Exception e)
					{
					}		   
				}
			}
		}
		return false;
	}
	
	//main����
	public static void main(String[] args)
	{
	    new FileFilter();
	}
}