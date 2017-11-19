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
//主界面

public class MainInterface extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//初始化对象
	public static TestDriver test_driver = new TestDriver();
	public static ScanElement element_set = new ScanElement();
	public static CleverReproduce auto_test = new CleverReproduce();
	
	public static String home_url;
	
	//初始化主界面按钮
	JButton init_btn = new JButton("打开网页");
	JButton record_script_btn = new JButton("录制新脚本");
    JButton read_script_btn = new JButton("运行已有脚本");
    JButton confirm_btn = new JButton("完成录制");
    JButton scan_btn = new JButton("智能测试");
    JTextField url_input = new JTextField();
    
    //窗体大小
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
    
	public MainInterface() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
	    setTitle("LCL");

	    //添加按钮监听事件
	    init_btn.addActionListener(this);
	    record_script_btn.addActionListener(this);
	    read_script_btn.addActionListener(this);
	    confirm_btn.addActionListener(this);
	    scan_btn.addActionListener(this);
	    
	    //设置四个按钮的位置
	    Box hbox1 = Box.createHorizontalBox();
	    Box hbox2 = Box.createHorizontalBox();
	    Box hbox3 = Box.createHorizontalBox();
	    Box hbox4 = Box.createHorizontalBox();
	    Box hbox5 = Box.createHorizontalBox();
	    
	    //按钮绑定
	    hbox1.add(url_input);
	    hbox1.add(init_btn);
	    hbox2.add(record_script_btn);
	    hbox3.add(read_script_btn);
	    hbox4.add(confirm_btn);
	    hbox5.add(scan_btn);
	    
	    //把按钮加到界面上
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
	    System.out.println("界面初始化成功!");
	}

	//
	public void actionPerformed(ActionEvent evt){
    	
		//设置按钮对应事件
		Object btn = evt.getSource();
		
		if(btn == init_btn){
			
			home_url = url_input.getText();
			test_driver.init();
	    	test_driver.loadHomeUrl(home_url);
	    	System.out.println("网页打开成功!");
	    	
		}
		else if(btn == record_script_btn){
			
    		System.out.println("开始录制...");
    		new EnterPageNum();
    		
		}else if(btn == read_script_btn){
			
			//打开回放界面
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
