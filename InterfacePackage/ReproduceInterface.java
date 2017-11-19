package InterfacePackage;

import javax.swing.*;

import MainPackage.TestDriver;
import TestPackage.StupidReproduce;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReproduceInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JButton script_choose = new JButton("选择脚本");
	JButton script_rep = new JButton("脚本回放");
	JTextField file_res = new JTextField();
	
	JFileChooser jfc = new JFileChooser();//文件选择器

	File choosen_file = null;//选中的文件
	
    public ReproduceInterface() {
    	
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setVisible(true);
    	setSize(300, 300); 
	    setTitle("回放");
	    
	    script_choose.addActionListener(this);
	    script_rep.addActionListener(this);
	    
	    Box hbox1 = Box.createHorizontalBox();
	    Box hbox2 = Box.createHorizontalBox();
	    Box vbox = Box.createVerticalBox();
	    
	    hbox1.add(script_choose);
	    hbox1.add(file_res);
	    hbox2.add(script_rep);
	    
	    vbox.add(Box.createVerticalStrut(20));
	    vbox.add(hbox1);
	    vbox.add(Box.createVerticalStrut(20));
	    vbox.add(hbox2);
	    
	    add(vbox, BorderLayout.CENTER);
    }
    
    public void actionPerformed(ActionEvent evt) {
    	
    	Object btn = evt.getSource();
    	if (btn == script_choose) {
    		
    		System.out.println("选择文件...");
    		
    		//打开文件选择器
    		jfc.setFileSelectionMode(0);//设定只能选择到文件
            int state = jfc.showOpenDialog(null);//此句是打开文件选择器界面的触发语句
            
            if(state == 1){
                return;//撤销则返回
            }
            else{
                choosen_file = jfc.getSelectedFile();//f为选择到的文件
                file_res.setText(choosen_file.getAbsolutePath());
                System.out.println(choosen_file.getAbsolutePath());
            }
    		System.out.println("完成");	
    	}
    	else if (btn == script_rep) {
    		
    		if(choosen_file != null){
    			
    			if(choosen_file.getName().endsWith(".txt")){
    				System.out.println("开始回放！");
    				
    				try {
						StupidReproduce.reproduce(choosen_file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    			else{
    				//弹出错误框
        			JOptionPane.showMessageDialog(this.getContentPane(),
        					"脚本格式错了呢~！", "不行哦！", JOptionPane.ERROR_MESSAGE);
        			System.out.println("脚本格式错误T T");
    			}
    		}
    		else{
    			//弹出警告框
    			JOptionPane.showMessageDialog(this.getContentPane(),
    					"请选择一个脚本~", "不行哦！", JOptionPane.WARNING_MESSAGE);
    			System.out.println("脚本为空T T");
    		}
    	}
    }
}
