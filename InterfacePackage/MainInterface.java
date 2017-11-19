package InterfacePackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import MainPackage.TestDriver;
import TestPackage.CleverReproduce;
import TestPackage.ManualRecord;
import TestPackage.ScanElement;
//������

public class MainInterface extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//��ʼ������
	public static TestDriver test_driver = new TestDriver();
	public static ScanElement element_set = new ScanElement();
	public static CleverReproduce auto_test = new CleverReproduce();
	
	public static String home_url;
	
	//��ʼ�������水ť
	JButton init_btn = new JButton("����ҳ");
	JButton record_script_btn = new JButton("¼���½ű�");
    JButton read_script_btn = new JButton("�������нű�");
    JButton confirm_btn = new JButton("���¼��");
    JButton scan_btn = new JButton("���ܲ���");
    JTextField url_input = new JTextField();
    
    //�����С
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
    
	public MainInterface() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
	    setTitle("LCL");

	    //��Ӱ�ť�����¼�
	    init_btn.addActionListener(this);
	    record_script_btn.addActionListener(this);
	    read_script_btn.addActionListener(this);
	    confirm_btn.addActionListener(this);
	    scan_btn.addActionListener(this);
	    
	    //�����ĸ���ť��λ��
	    Box hbox1 = Box.createHorizontalBox();
	    Box hbox2 = Box.createHorizontalBox();
	    Box hbox3 = Box.createHorizontalBox();
	    Box hbox4 = Box.createHorizontalBox();
	    Box hbox5 = Box.createHorizontalBox();
	    
	    //��ť��
	    hbox1.add(url_input);
	    hbox1.add(init_btn);
	    hbox2.add(record_script_btn);
	    hbox3.add(read_script_btn);
	    hbox4.add(confirm_btn);
	    hbox5.add(scan_btn);
	    
	    //�Ѱ�ť�ӵ�������
	    Box vbox = Box.createVerticalBox();
	    vbox.add(Box.createVerticalStrut(60));
	    vbox.add(hbox1);
	    vbox.add(Box.createVerticalStrut(60));
	    vbox.add(hbox2);
	    vbox.add(Box.createVerticalStrut(60));
	    vbox.add(hbox3);
	    vbox.add(Box.createVerticalStrut(60));
	    vbox.add(hbox4);
	    vbox.add(Box.createVerticalStrut(60));
	    vbox.add(hbox5);
	    
	    add(vbox, BorderLayout.CENTER);
	    System.out.println("�����ʼ���ɹ�!");
	}

	//
	public void actionPerformed(ActionEvent evt){
    	
		//���ð�ť��Ӧ�¼�
		Object btn = evt.getSource();
		
		if(btn == init_btn){
			
			home_url = url_input.getText();
			test_driver.init();
	    	test_driver.loadHomeUrl(home_url);
	    	System.out.println("��ҳ�򿪳ɹ�!");
	    	
		}
		else if(btn == record_script_btn){
			
    		System.out.println("��ʼ¼��...");
    		new EnterPageNum();
    		
		}else if(btn == read_script_btn){
			
			//�򿪻طŽ���
			new ReproduceInterface();
			
		}else if(btn == confirm_btn){
			
			new SaveFileInterface();
           
			
		}else if(btn == scan_btn){
			
			home_url = url_input.getText();
			test_driver.init();
	    	test_driver.loadHomeUrl(home_url);
	    	element_set.set();
	    	auto_test.start(element_set.buttons,element_set.inputs,element_set.links);
	    	
 		}else{
			
		}
	}	
}
