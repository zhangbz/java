import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Test
{
    private JFrame f;
    private JLabel l;
    private JPanel p,p_b;
    private JButton bt_add,bt_rm,bt_scan;
    private JCheckBox cb;
    private FileDialog openDia;
    private File file;
    private JFileChooser fc;
	
    public Test()
    {
        init();
    }
	
    private void init()
    {
	f = new JFrame("Test");
	f.setBounds(300, 100, 600, 500);
	//f.setResizable(false);
		
	l = new JLabel("任务列表");
	p = new JPanel();
	p.setLayout(new GridLayout(10,1));
	//p.setBackground(Color.red);
	cb = new JCheckBox("checkbox");
	cb.setVisible(false);
		
	p_b = new JPanel(new GridLayout(1,3));
		
	bt_add = new JButton("Add");
	bt_rm = new JButton("Remove");
	bt_scan = new JButton("Scan");
		
	p.add(cb);
		
	p_b.add(bt_add);
        p_b.add(bt_scan);
        p_b.add(bt_rm);
		
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        openDia = new FileDialog(f, "open", FileDialog.LOAD);
	  
        //p.add(bt1);
        //p.add(bt2);
        //p.add(bt3);
		
        f.add(l, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.add(p_b,BorderLayout.SOUTH);
		
        myEvent();
		
        f.setVisible(true);
    }
	
    private void  myEvent()
    {
        bt_add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
	    {
	        cb.setVisible(true);
			    
	        fc.showOpenDialog(f);
	        String dirPath = fc.getSelectedFile().toString();
                //openDia.setVisible(true);
                //String dirPath = openDia.getDirectory();
                //String fileName = openDia.getFile();
                
                if(dirPath == null )
                    return;
                
                file = new File(dirPath);
				
                cb = new JCheckBox(dirPath);
       	        p.add(cb);
	        //cb.setVisible(true);
	        p.updateUI();
       	    }
	});
    }
    public static void main(String[] args)
    {
        new Test();
    }
}
