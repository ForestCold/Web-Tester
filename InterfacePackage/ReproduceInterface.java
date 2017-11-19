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
	
	JButton script_choose = new JButton("ѡ��ű�");
	JButton script_rep = new JButton("�ű��ط�");
	JTextField file_res = new JTextField();
	
	JFileChooser jfc = new JFileChooser();//�ļ�ѡ����

	File choosen_file = null;//ѡ�е��ļ�
	
    public ReproduceInterface() {
    	
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setVisible(true);
    	setSize(300, 300); 
	    setTitle("�ط�");
	    
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
    		
    		System.out.println("ѡ���ļ�...");
    		
    		//���ļ�ѡ����
    		jfc.setFileSelectionMode(0);//�趨ֻ��ѡ���ļ�
            int state = jfc.showOpenDialog(null);//�˾��Ǵ��ļ�ѡ��������Ĵ������
            
            if(state == 1){
                return;//�����򷵻�
            }
            else{
                choosen_file = jfc.getSelectedFile();//fΪѡ�񵽵��ļ�
                file_res.setText(choosen_file.getAbsolutePath());
                System.out.println(choosen_file.getAbsolutePath());
            }
    		System.out.println("���");	
    	}
    	else if (btn == script_rep) {
    		
    		if(choosen_file != null){
    			
    			if(choosen_file.getName().endsWith(".txt")){
    				System.out.println("��ʼ�طţ�");
    				
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
    				//���������
        			JOptionPane.showMessageDialog(this.getContentPane(),
        					"�ű���ʽ������~��", "����Ŷ��", JOptionPane.ERROR_MESSAGE);
        			System.out.println("�ű���ʽ����T T");
    			}
    		}
    		else{
    			//���������
    			JOptionPane.showMessageDialog(this.getContentPane(),
    					"��ѡ��һ���ű�~", "����Ŷ��", JOptionPane.WARNING_MESSAGE);
    			System.out.println("�ű�Ϊ��T T");
    		}
    	}
    }
}
