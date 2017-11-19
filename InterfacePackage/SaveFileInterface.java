package InterfacePackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SaveFileInterface extends JFrame implements ActionListener{
    
	private static final long serialVersionUID = 1L;
	
	JButton save = new JButton("保存");
	JButton cancel = new JButton("取消");
	JTextField file_res = new JTextField();
    
    public SaveFileInterface() {
    	
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setVisible(true);
    	setSize(300, 300); 
        setTitle("是否保存脚本？");
        
        save.addActionListener(this);
        cancel.addActionListener(this);
        
        Box hbox1 = Box.createHorizontalBox();
        Box hbox2 = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();
        
        hbox1.add(file_res);
        hbox2.add(save);
        hbox2.add(cancel);
        
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(hbox1);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(hbox2);
        
        add(vbox, BorderLayout.CENTER);
    	
    }
    
    public void actionPerformed(ActionEvent evt) {
    	
    	Object btn = evt.getSource();
    	
		String filename = file_res.getText();
		File oldfile = new File("D:/workspaceForWindows/Hanfei/scriptRecords/temp.txt"); 
	    File newfile = new File("D:/workspaceForWindows/Hanfei/scriptRecords/" + filename + ".txt"); 
	    
    	if (btn == save) {
    		 
			if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名 
			{
        		int isexist = JOptionPane.showConfirmDialog(null, "已经存在这个文件了，要替换吗?", "标题",JOptionPane.YES_NO_OPTION);
        		System.out.println(isexist);
        		if(isexist == 0){//替换文件
        			
        			newfile.delete(); 
        			oldfile.renameTo(newfile);
        			this.dispose();
        			
        		}else{//不替换文件
        			
        		}
			}
        	else{ 

        		oldfile.renameTo(newfile);
        		this.dispose();
        		
        	}
        	
    	}else if(btn == cancel){
    		
    		oldfile.delete(); 
    		this.dispose();
    		
    	}
    }
    
}
